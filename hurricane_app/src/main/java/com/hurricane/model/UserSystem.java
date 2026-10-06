package com.hurricane.model;

public class UserSystem {
    private UserList userList = UserList.getInstance();

    public User login(String userName, String password){
        return userList.getUser(userName, password);
    }
    
}
