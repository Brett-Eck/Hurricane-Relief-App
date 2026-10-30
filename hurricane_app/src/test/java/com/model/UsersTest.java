package com.model;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;

import java.util.*;

import com.hurricane.model.*;




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
}
