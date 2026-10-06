package com.hurricane.model;

import java.util.Scanner;

public class UserUI {
    private final UserSystem userSystem;
    private final Scanner scanner;

    public UserUI() {
        userSystem = new UserSystem();
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Hurricane Relief App");

        User user = login();

        if (user != null) {
            System.out.println("\nWelcome, " + user.getFirstName() + "!");
        } else {
            System.out.println("\nInvalid username or password.");
        }
    }

    private User login() {
        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        return userSystem.login(username, password);
    }

    public static void main(String[] args) {
        UserUI userUI = new UserUI();
        userUI.start();
    }
}