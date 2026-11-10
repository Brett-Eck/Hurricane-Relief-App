
package com.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.hurricane.model.Location;

public class LocationTest {

    @Test
    public void testLocationStreet() {
        Location location = new Location("759 King St", "Charleston", "SC", 29403);

        assertEquals("759 King St", location.getStreet());
    }

    @Test
    public void testLocationCity() {
        Location location = new Location("759 King St", "Charleston", "SC", 29403);

        assertEquals("Charleston", location.getCity());
    }

    @Test
    public void testLocationState() {
        Location location = new Location("759 King St", "Charleston", "SC", 29403);

        assertEquals("SC", location.getState());
    }

    @Test
    public void testLocationZipCode() {
        Location location = new Location("759 King St", "Charleston", "SC", 29403);

        assertEquals(29403, location.getZipCode());
    }
}
