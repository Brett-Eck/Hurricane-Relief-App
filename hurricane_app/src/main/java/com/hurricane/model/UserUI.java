package com.hurricane.model;

import java.time.LocalDate;

public class UserUI {
    private UserSystem userSystem = new UserSystem();

    public static void main(String[] args){
        UserUI userUI = new UserUI();
        userUI.run();
    }

    public void run(){
        scenario1();
        scenario2();
        scenario3();
    }

    public void scenario1(){
        userSystem.login("greggoat", "passwordevilmode");
        if (userSystem.login("greggoat", "passwordevilmode") != null){
            System.out.println(userSystem.getUser().getFirstName() + " " + userSystem.getUser().getLastName());
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: user not found or password incorrect");
        }
    }

    public void scenario2(){
        userSystem.signup("John", "Doe", LocalDate.of(1995, 5, 15), "johndoe", "password123", "jondoe@example.com");
        if (userSystem.login("johndoe", "password123") != null){
            System.out.println(userSystem.getCurrentUser().getFirstName() + " " + userSystem.getCurrentUser().getLastName());
            System.out.println("Signup successful");
        } else {
            System.out.println("Signup failed");
        }
    }

    public void scenario3(){
        userSystem.login("greggoat", "passwordevilmode");
        if (userSystem.login("greggoat", "passwordevilmode") != null){
            System.out.println(userSystem.getUser().getFirstName() + " " + userSystem.getUser().getLastName());
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: user not found or password incorrect");
        }
        for (Shelter shelter : userSystem.getShelters()){
            System.out.println(shelter.getShelterName());
        }

    }
}