package com.hurricane.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class UserSystem {
    private UserList userList = UserList.getInstance();
    private ReliefRequestList reliefRequestList = ReliefRequestList.getInstance();
    private ShelterList shelterList = ShelterList.getInstance();
    private HurricaneList hurricaneList = HurricaneList.getInstance();

    private User currentUser;
    private Hurricane currentHurricane;

    public User login(String userName, String password) {
        currentUser = userList.getUser(userName, password);
        return currentUser;
    }

    public void logout() {
        currentUser = null;
    }

    public User getUser() {
        return currentUser;
    }

    public User signup(String firstName, String lastName, LocalDate birthDate,
            String userName, String password, String email) {
        userList.addUser(firstName, lastName, birthDate, userName, password, email);
        return userList.getUser(userName, password);
    }

    public ArrayList<User> getUsers() {
        return userList.getUsers();
    }

    public ArrayList<Shelter> getShelters() {
        return shelterList.getShelters();
    }

    public ArrayList<ShelterManager> getShelterManagers(Shelter shelter) {
        return shelter.getShelterManagers();
    }

    public ArrayList<Volunteer> getVolunteers() {
        return userList.getVolunteers();
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        return reliefRequestList.getReliefRequests();
    }

    public Hurricane getHurricane() {
        return currentHurricane;
    }

    public Hurricane getHurricane(Location location) {
        currentHurricane = hurricaneList.getHurricane(location);
        return currentHurricane;
    }

    public ReliefRequest createReliefRequest(ArrayList<Victim> victims, ArrayList<Hazard> hazards,
            String photo, ArrayList<AssistanceType> assistanceTypes, Status status,
            String description, String phoneNumber, UUID id, Location location) {
        return new ReliefRequest(victims, hazards, photo, assistanceTypes, status,
                description, phoneNumber, id, location);
    }

    public void submitReliefRequest(ReliefRequest request) {
        reliefRequestList.addReliefRequest(request);
    }

    public void editReliefRequest(ReliefRequest request, String description, Status status) {
        request.setDescription(description);
        request.setStatus(status);
    }

    public boolean assignUserToShelter(Shelter shelter, Volunteer volunteer) {
        if (shelter.getShelterManagers().isEmpty()) {
            return false;
        }

        shelter.getShelterManagers().get(0).addShelterVolunteer(volunteer);
        return true;
    }

    public void acceptReliefRequest(ReliefRequest request) {
        request.setStatus(Status.IN_PROGRESS);
    }

    public void acceptRequest(Volunteer volunteer, ReliefRequest request) {
        volunteer.acceptRequest(request);

        if (request != null && request.isAccepted()) {
            request.setStatus(Status.IN_PROGRESS);
        }
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public User getUser(String userName, String password) {
        return userList.getUser(userName, password);
    }
}