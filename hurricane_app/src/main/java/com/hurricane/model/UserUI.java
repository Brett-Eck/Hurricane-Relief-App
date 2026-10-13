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
        createReliefRequestScenario();
        acceptReliefRequestScenario();
    }

    public void scenario1(){
        userSystem.login("greggoat", "passwordevilmode");

        if (userSystem.login("greggoat", "passwordevilmode") != null){
            System.out.println(userSystem.getCurrentUser().getFirstName() + " " + userSystem.getCurrentUser().getLastName());
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: user not found or password incorrect");
        }
    }

    public void scenario2(){
        userSystem.signup(
                "John",
                "Doe",
                LocalDate.of(1995, 5, 15),
                "johndoe",
                "password123",
                "jondoe@example.com"
        );

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

    public void createReliefRequestScenario(){
        ReliefRequest request = userSystem.createReliefRequest();

        userSystem.submitReliefRequest(request);

        if (request != null){
            System.out.println("Relief request created");
            System.out.println("Relief request submitted");
        } else {
            System.out.println("Relief request failed");
        }
    }

    public void acceptReliefRequestScenario(){
        ReliefRequest request = userSystem.createReliefRequest();

        Volunteer volunteer = new Volunteer();

        userSystem.acceptRequest(volunteer, request);

        System.out.println("Volunteer accepted relief request");
    }
}