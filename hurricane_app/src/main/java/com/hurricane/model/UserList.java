package com.hurricane.model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Manages users in the system. Singleton to make sure only one instance of user list exists.
 * UserList
*/

public class UserList {
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();
    LocalDate date = LocalDate.now();
    private static UserList userList = new UserList();
    private final ArrayList<User> users;

    /**
     * Hard coded user for testing. Replace later.
     */
    public UserList(){
        users = dataLoader.getUsers();
    }

    /**
     * Adds a volunteer to the user list.
     *
     * @param volunteer the volunteer to add
     */
    public void addVolunteer(Volunteer volunteer) {
        users.add(volunteer);
    }

    /**
     * Gets the single instance of UserList.
     *
     * @return the UserList instance
     */
    public static UserList getInstance(){
        return userList;
    }

    /**
     * Finds a user using their username and password.
     *
     * @param userName the username to check
     * @param password the password to check
     * @return the matching user, or null if not found
     */
    public User getUser(String userName, String password){
        for (User user : users){
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        System.out.println("User not found or password incorrect");
        return null;
    }

    /**
     * Creates a new user and adds them to the list.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param birthDate the user's birth date
     * @param userName the username
     * @param password the password
     * @param email the user's email
     * @param location the user's location
     * @return true after the user is added
     */
    public boolean addUser(String firstName, String lastName, LocalDate birthDate, String userName, String password, String email, Location location){
        users.add(new User(firstName, lastName, birthDate, email, password, userName, location));
        return true;
    }

    /**
     * Gets all users in the system.
     *
     * @return the list of users
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Finds all users who are volunteers.
     *
     * @return the list of volunteers
     */
    public ArrayList<Volunteer> getVolunteers() {
        ArrayList<Volunteer> volunteers = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Volunteer) {
                volunteers.add((Volunteer) user);
            }
        }
        return volunteers;
    }

    /**
     * Finds all users who are shelter managers.
     *
     * @return the list of shelter managers
     */
    public ArrayList<User> getShelterManagers() {
        ArrayList<User> shelterManagers = new ArrayList<>();
        for (User user : users) {
            if (user instanceof ShelterManager) {
                shelterManagers.add(user);
            }
        }
        return shelterManagers;
    }

    /**
     * No database yet, just true for now. Replace later.
     * @return
     */
    public boolean saveUser(){
        dataWriter.saveUsers();
        return true;
    }
}
