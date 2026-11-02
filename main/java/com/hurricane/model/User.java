package com.hurricane.model;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.UUID;

/* User class representing a user in the hurricane relief application */
/**
 * @author Nyesh1
 */

public class User {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String email;
    private String password;
    private String userName;
    private Location location;
    private UUID id;
    private ArrayList<ReliefRequest> requests;

    /**
     * Creates a user with their personal and account information.
     *
     * @param firstName the user's first name
     * @param lastName the user's last name
     * @param birthDate the user's birth date
     * @param email the user's email
     * @param password the user's password
     * @param username the user's username
     * @param location the user's location
     */
    public User(String firstName, String lastName, LocalDate birthDate,
                String email, String password, String username, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.location = location;
        this.userName = username;
        this.id = UUID.randomUUID();
        this.requests = new ArrayList<>();
    }

    /**
     * Checks if the username and password match the user's information.
     *
     * @param userName the username to check
     * @param password the password to check
     * @return true if both match, false otherwise
     */
    public boolean isMatch(String userName, String password) {
        return this.userName != null
            && this.password != null
            && this.userName.equals(userName)
            && this.password.equals(password);
    }

    /**
     * Gets the user's location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the user's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the user's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the user's birth date.
     *
     * @return the birth date
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Gets the user's email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the user's password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the user's username.
     *
     * @return the username
     */
    public String getUsername() {
        return userName;
    }

    /**
     * Gets the user's unique ID as a string.
     *
     * @return the user ID
     */
    public String getId() {
        return id.toString();
    }
}