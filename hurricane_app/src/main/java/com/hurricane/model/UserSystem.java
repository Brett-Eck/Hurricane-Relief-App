package com.hurricane.model;
import java.time.LocalDate;

public class UserSystem {
    private UserList userList = UserList.getInstance();

    public User login(String userName, String password){
        return userList.getUser(userName, password);
    }

    public User signup(String firstName, String lastName, LocalDate birthDate, String userName, String password, String email){
        userList.addUser(firstName, lastName, birthDate, userName, password, email);
        return userList.getUser(userName, password);
    }
    
}
