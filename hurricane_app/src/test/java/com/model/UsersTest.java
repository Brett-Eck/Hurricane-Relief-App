package com.model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Assert.*;

import com.hurricane.model.User;
import com.hurricane.model.UserSystem;

public class UsersTest {
    private final UserSystem userSystem = UserSystem.getInstance();

    @Test
    public void testValidLogin() {
        User user = userSystem.login("ecarter", "hashed_password_here");

        assertNotNull("Login should return a user", user);
        assertEquals("Emily", user.getFirstName());
    }
    
}
