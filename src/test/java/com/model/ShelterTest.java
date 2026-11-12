package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.model.Availability;
import com.model.Filter;
import com.model.Location;
import com.model.Shelter;
import com.model.ShelterManager;

public class ShelterTest {
    private Shelter shelter;
    private Location location;

    @Before
    public void setUp() {
        location = new Location("123 Main St", "Charleston", "SC", 29403);
        shelter = new Shelter("Community Shelter", 100, location);
    }

    /*
    +--------------------------------+-------------------------------------------------------------------+
    | Test                                | Reasoning                                                         
    +--------------------------------+--------------------------------------------------------------------+
    | Add Filters                    |   Shelters should be able to have multiple filters
    | Test Availability              |   Shelters' Availability should be updated to Full when at max occupancy   
    | Add Null manager               |   Shelters should not be able to have no managers    
    | Add Null Filter                |   Shelters should be able to have no filters
    | Add Multiple managers          |   Shelters should be able to have multiple managers 
    | Add Null Name Shleter          |   Shelters need a name      
    +--------------------------------+--------------------------------------------------------------------+ */

    @Test
    public void testAddFilters() {
        shelter.addFilter(Filter.PET_FRIENDLY);
        shelter.addFilter(Filter.FOOD);

        assertEquals(2, shelter.getFilters().size());
        assertTrue(shelter.getFilters().contains(Filter.PET_FRIENDLY));
        assertTrue(shelter.getFilters().contains(Filter.FOOD));
    }

    @Test
    public void testAvailability() {
        shelter.setCurrentOccupancy(shelter.getCapacity());
        assertEquals(Availability.FULL, shelter.getAvailability());
    }

    @Test
    public void testAddNullManager() {
        shelter.addShelterManager(null);
        assertNotNull(shelter.getShelterManagers().get(0));
    }

    @Test
    public void testAddNullFilter() {
        shelter.addFilter(null);

        assertTrue("A null filter should leave the shelter with no filters",
            shelter.getFilters().isEmpty());
    }

    @Test
    public void testAddMultipleManagers() {
        ShelterManager firstManager = new ShelterManager(
            "Jane", "Doe", LocalDate.of(1985, 6, 15),
            "jane@example.com", "password123", "jane_manager", location
        );
        ShelterManager secondManager = new ShelterManager(
            "John", "Smith", LocalDate.of(1990, 3, 20),
            "john@example.com", "password456", "john_manager", location
        );

        shelter.addShelterManager(firstManager);
        shelter.addShelterManager(secondManager);

        assertEquals(2, shelter.getShelterManagers().size());
        assertTrue(shelter.getShelterManagers().contains(firstManager));
        assertTrue(shelter.getShelterManagers().contains(secondManager));
    }

    @Test
    public void testNullShelterName() {
        Shelter shelter = new Shelter(null, 100, location);
        assertNotNull(shelter.getShelterName());
    }
}
