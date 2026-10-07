package com.hurricane.model;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Manages users in the system. Singleton to make sure only one instance of user list exists.
 * UserList
*/

public class UserList {
    LocalDate date = LocalDate.now();
    private static UserList userList = new UserList();
    private ArrayList<User> users = new ArrayList<>();

    /**
     * Hard coded user for testing. Replace later.
     */
    public UserList(){
        users.add(new User("Greg", "Goat", null, "greggoat", "passwordevilmode", "greggoat@example.com"));
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
        return null;
    }

    public boolean addUser(String firstName, String lastName, LocalDate birthDate, String userName, String password, String email){
        users.add(new User(firstName, lastName, birthDate, email, password, userName));
        return true;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * No database yet, just true for now. Replace later.
     * @return
     */
    public boolean saveUser(){
        return true;
    }
}
