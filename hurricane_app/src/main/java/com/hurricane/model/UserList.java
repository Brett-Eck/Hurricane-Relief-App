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

    public void addVolunteer(Volunteer volunteer) {
        users.add(volunteer);
    }

    public static UserList getInstance(){
        return userList;
    }

    public User getUser(String userName, String password){
        for (User user : users){
            if (user.getUsername().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        System.out.println("User not found or password incorrect");
        return null;
    }

    public boolean addUser(String firstName, String lastName, LocalDate birthDate, String userName, String password, String email, Location location){
        users.add(new User(firstName, lastName, birthDate, email, password, userName, location));
        return true;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Volunteer> getVolunteers() {
        ArrayList<Volunteer> volunteers = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Volunteer) {
                volunteers.add((Volunteer) user);
            }
        }
        return volunteers;
    }

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
