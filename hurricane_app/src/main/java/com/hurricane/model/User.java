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

    public User(String firstName, String lastName, LocalDate birthDate,
                String email, String password, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.userName = username;
        this.id = UUID.randomUUID();
        this.requests = new ArrayList<>();
    }

    public boolean isMatch(String userName, String password) {
        return this.userName != null
            && this.password != null
            && this.userName.equals(userName)
            && this.password.equals(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return userName;
    }
}