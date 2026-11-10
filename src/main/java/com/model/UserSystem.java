package com.hurricane.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Handles user accounts, shelters, hurricanes, and relief requests.
 */
public class UserSystem {
    private UserList userList = UserList.getInstance();
    private ReliefRequestList reliefRequestList = ReliefRequestList.getInstance();
    private ShelterList shelterList = ShelterList.getInstance();
    private HurricaneList hurricaneList = HurricaneList.getInstance();

    private User currentUser;
    private Hurricane currentHurricane;
    private static UserSystem userSystem;

    /**
     * Logs in a user with their username and password.
     *
     * @param userName the username
     * @param password the password
     * @return the user if found, or null if not
     */
    public User login(String userName, String password) {
        currentUser = userList.getUser(userName, password);
        return currentUser;
    }

    public static UserSystem getInstance() {
        if (userSystem == null){
            return new UserSystem();
        }
        return userSystem;
    }

    /**
     * Logs out the current user.
     */
    public void logout() {
        currentUser = null;
    }

    /**
     * Gets the currently logged in user.
     *
     * @return the current user
     */
    public User getUser() {
        return currentUser;
    }

    /**
     * Creates a new user account.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param birthDate the user's birth date
     * @param userName the username
     * @param password the password
     * @param email the user's email
     * @param location the user's location
     * @return the newly created user
     */
    public User signup(String firstName, String lastName, LocalDate birthDate,
            String userName, String password, String email, Location location) {
        userList.addUser(firstName, lastName, birthDate, userName, password, email, location);
        return userList.getUser(userName, password);
    }

    /**
     * Converts an existing user into a volunteer.
     *
     * @param userName the username
     * @param password the password
     * @return the volunteer if the user is found, or null if not
     */
    public User becomeVolunteer(String userName, String password) {
        User user = userList.getUser(userName, password);
        if (user != null) {
            Volunteer volunteer = new Volunteer(user.getFirstName(), user.getLastName(), user.getBirthDate(),
                    user.getEmail(), user.getPassword(), user.getUsername(), user.getLocation());
            userList.addVolunteer(volunteer);
            return volunteer;
        }
        return null;
    }

    /**
     * Gets all registered users.
     *
     * @return the list of users
     */
    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    /**
     * Gets all shelters.
     *
     * @return the list of shelters
     */
    public ArrayList<Shelter> getShelters() {
        return shelterList.getShelters();
    }

    /**
     * Finds shelters that match the requested filters.
     *
     * @param requestedFilters the filters to search by
     * @return the list of matching shelters
     */
    public ArrayList<Shelter> findShelters(ArrayList<Filter> requestedFilters) {
        return ShelterList.getInstance().findShelters(requestedFilters);
    }

    /**
     * Gets the managers assigned to a shelter.
     *
     * @param shelter the shelter to check
     * @return the list of shelter managers
     */
    public ArrayList<ShelterManager> getShelterManagers(Shelter shelter) {
        return shelter.getShelterManagers();
    }

    /**
     * Gets all registered volunteers.
     *
     * @return the list of volunteers
     */
    public ArrayList<Volunteer> getVolunteers() {
        return userList.getVolunteers();
    }

    /**
     * Gets all relief requests.
     *
     * @return the list of relief requests
     */
    public ArrayList<ReliefRequest> getReliefRequests() {
        return reliefRequestList.getReliefRequests();
    }

    /**
     * Gets the current hurricane.
     *
     * @return the current hurricane
     */
    public Hurricane getHurricane() {
        return currentHurricane;
    }

    /**
     * Finds the hurricane at a given location.
     *
     * @param location the location to check
     * @return the hurricane at that location
     */
    public Hurricane getHurricane(Location location) {
        currentHurricane = hurricaneList.getHurricane(location);
        return currentHurricane;
    }

    /**
     * Creates a relief request using the provided information.
     *
     * @param userName the username of the person making the request
     * @param victims the people needing assistance
     * @param hazards the hazards at the location
     * @param photo the photo information
     * @param assistanceTypes the types of assistance needed
     * @param status the request's status
     * @param description the request description
     * @param phoneNumber the contact phone number
     * @param id the request ID
     * @param location the location of the request
     * @return the new relief request
     */
    public ReliefRequest createReliefRequest(String userName, ArrayList<Victim> victims, ArrayList<Hazard> hazards,
            String photo, ArrayList<AssistanceType> assistanceTypes, Status status,
            String description, String phoneNumber, UUID id, Location location) {
        return new ReliefRequest(userName, victims, hazards, photo, assistanceTypes, status,
                description, phoneNumber, id, location);
    }

    /**
     * Adds a relief request to the request list.
     *
     * @param request the relief request to submit
     */
    public void submitReliefRequest(ReliefRequest request) {
        reliefRequestList.addReliefRequest(request);
    }

    /**
     * Updates a relief request's description and status.
     *
     * @param request the relief request to update
     * @param description the new description
     * @param status the new status
     */
    public void editReliefRequest(ReliefRequest request, String description, Status status) {
        request.setDescription(description);
        request.setStatus(status);
    }

    /**
     * Assigns a volunteer to a shelter through its first manager.
     *
     * @param shelter the shelter
     * @param volunteer the volunteer to assign
     * @return true if assigned, or false if no manager is available
     */
    public boolean assignUserToShelter(Shelter shelter, Volunteer volunteer) {
        if (shelter.getShelterManagers().isEmpty()) {
            return false;
        }

        shelter.getShelterManagers().get(0).addShelterVolunteer(volunteer);
        return true;
    }

    /**
     * Changes a relief request's status to in progress.
     *
     * @param request the relief request to update
     */
    public void acceptReliefRequest(ReliefRequest request) {
        request.setStatus(Status.IN_PROGRESS);
    }

    /**
     * Has a volunteer accept a relief request.
     *
     * @param volunteer the volunteer accepting the request
     * @param request the relief request being accepted
     */
    public void acceptRequest(Volunteer volunteer, ReliefRequest request) {
        volunteer.acceptRequest(request);

        if (request != null && request.isAccepted()) {
            request.setStatus(Status.IN_PROGRESS);
        }
    }

    /**
     * Returns the current user.
     *
     * @return the current user
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Finds a user using their username and password.
     *
     * @param userName the username
     * @param password the password
     * @return the matching user, or null if not found
     */
    public User getUser(String userName, String password) {
        return userList.getUser(userName, password);
    }

    // public ReliefRequest createReliefRequestScenario() {
    //     ArrayList<Victim> victims = new ArrayList<>();
    //     victims.add(new Victim("John", VictimStatus.MAJOR_INJURY));

    //     ArrayList<Hazard> hazards = new ArrayList<>();

    //     ArrayList<AssistanceType> assistanceTypes = new ArrayList<>();
    //     assistanceTypes.add(AssistanceType.MEDICAL);


    // }

    /**
     * Finds the nearest relief request to a location.
     *
     * @param location the location to search from
     * @return the nearest relief request
     */
    public ReliefRequest findNearestReliefRequest(Location location) {
    return reliefRequestList.findNearestReliefRequest(location);
}
}