package com.model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import java.util.*;

import com.hurricane.*;




public class UsersTest {
    private final UserSystem userSystem = UserSystem.getInstance();
    private UserList Users = UserList.getInstance();
    private ArrayList<User> userList = Users.getUsers();


    @Test
    public void testValidLogin() {
        User user = userSystem.login("ecarter", "hashed_password_here");

        assertEquals("Emily", user.getFirstName());
    }

    @Test
    public void testValidEmail(){
        User user =  userSystem.signup("John", "Doe", LocalDate.of(1980, 3, 14), "jdoe", "sophie123", "jsmith@example.com", new Location("759 King St", "Charleston", "SC", 29403));
        assertNotNull(user);
    }
    
    @Test
    public void testEmailNoAt(){
        User user =  userSystem.signup("John", "Doe", LocalDate.of(1980, 3, 14), "jdoe", "sophie123", "jsmithexample.com", new Location("759 King St", "Charleston", "SC", 29403));
        assertNull(user);
    }

    @Test
    public void testDuplicateUsername() {
        User firstUser = userSystem.signup(
            "John", "Doe", LocalDate.of(1980, 3, 14),
            "duplicate_username_test", "sophie123", "first@example.com",
            new Location("759 King St", "Charleston", "SC", 29403)
        );
        assertNotNull(firstUser);

        User secondUser = userSystem.signup(
            "Jane", "Doe", LocalDate.of(1990, 5, 20),
            "duplicate_username_test", "another123", "second@example.com",
            new Location("759 King St", "Charleston", "SC", 29403)
        );
        assertNull(secondUser);
    }

    @Test
    public void testLoginAfterSignup() {
        User createdUser = userSystem.signup(
            "John", "Doe", LocalDate.of(1980, 3, 14),
            "signup_login_test", "sophie123", "signup.login@example.com",
            new Location("759 King St", "Charleston", "SC", 29403)
        );

        assertNotNull(createdUser);

        User loggedInUser = userSystem.login("signup_login_test", "sophie123");

        assertNotNull(loggedInUser);
        assertEquals("John", loggedInUser.getFirstName());
    }

    @Test
    public void testEmptyEmail() {
        User user = userSystem.signup(
            "John", "Doe", LocalDate.of(1980, 3, 14),
            "empty_email_test", "sophie123", "",
            new Location("759 King St", "Charleston", "SC", 29403)
        );

        assertNull(user);
    }
}
