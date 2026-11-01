package com.model;

import java.time.LocalDate;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import com.hurricane.model.Location;
import com.hurricane.model.ShelterManager;
import com.hurricane.model.Shelter;
import com.hurricane.model.Volunteer;

//*Could possibly add tests regarding updating null shelter, zero capacity, and an initially empty volunteer list

public class ShelterManagerTest {
    
@Test
    public void testShelterManagerInitialization() {
        ShelterManager shelterManager = createShelterManager();
        assertNotNull(shelterManager);
    }

@Test
    public void testUpdateShelterCapacity() {
        ShelterManager shelterManager = createShelterManager();
        Shelter shelter = new Shelter("Shelter A", 100, new Location("123 Main St", "Columbia", "SC", 29201));

        shelterManager.updateShelterCapacity(shelter, 150);

        assertEquals(150, shelter.getCapacity());
    }

@Test
    public void testUpdateShelterCapacityRejectsNegativeCapacity() {
        ShelterManager shelterManager = createShelterManager();
        Shelter shelter = new Shelter("Shelter A", 100, new Location("123 Main St", "Columbia", "SC", 29201));

        assertThrows(IllegalArgumentException.class, () -> shelterManager.updateShelterCapacity(shelter, -1));
    }

    private ShelterManager createShelterManager() {
        return new ShelterManager(
            "Casey",
            "McManager",
            LocalDate.of(1990, 1, 1),
            "casey@example.com",
            "password",
            "casey",
            new Location("123 Main St", "Columbia", "SC", 29201)
        );
    }

@Test
    public void testAddShelterVolunteer() {
    ShelterManager shelterManager = createShelterManager();
    Volunteer volunteer = createVolunteer("alex");

    shelterManager.addShelterVolunteer(volunteer);

    assertEquals(1, shelterManager.getShelterVolunteers().size());
    assertTrue(shelterManager.getShelterVolunteers().contains(volunteer));
    }

@Test
    public void testAddMultipleShelterVolunteers() {
        ShelterManager shelterManager = createShelterManager();
        Volunteer firstVolunteer = createVolunteer("alex");
        Volunteer secondVolunteer = createVolunteer("steve");

        shelterManager.addShelterVolunteer(firstVolunteer);
        shelterManager.addShelterVolunteer(secondVolunteer);

        assertEquals(2, shelterManager.getShelterVolunteers().size());
        assertTrue(shelterManager.getShelterVolunteers().contains(firstVolunteer));
        assertTrue(shelterManager.getShelterVolunteers().contains(secondVolunteer));
    }

@Test
    public void testRemoveShelterVolunteer() {
        ShelterManager shelterManager = createShelterManager();
        Volunteer volunteer = createVolunteer("alex");
        shelterManager.addShelterVolunteer(volunteer);

        shelterManager.removeShelterVolunteer(volunteer);

        assertEquals(0, shelterManager.getShelterVolunteers().size());
        assertFalse(shelterManager.getShelterVolunteers().contains(volunteer));
    }

@Test
    public void testRemoveVolunteerKeepsOtherVolunteers() {
        ShelterManager shelterManager = createShelterManager();
        Volunteer firstVolunteer = createVolunteer("alex");
        Volunteer secondVolunteer = createVolunteer("steve");
        shelterManager.addShelterVolunteer(firstVolunteer);
        shelterManager.addShelterVolunteer(secondVolunteer);

        shelterManager.removeShelterVolunteer(firstVolunteer);

        assertEquals(1, shelterManager.getShelterVolunteers().size());
        assertFalse(shelterManager.getShelterVolunteers().contains(firstVolunteer));
        assertTrue(shelterManager.getShelterVolunteers().contains(secondVolunteer));
    }

@Test
    public void testRemoveUnassignedVolunteerLeavesListUnchanged() {
        ShelterManager shelterManager = createShelterManager();
        Volunteer assignedVolunteer = createVolunteer("alex");
        Volunteer unassignedVolunteer = createVolunteer("steve");
        shelterManager.addShelterVolunteer(assignedVolunteer);

        shelterManager.removeShelterVolunteer(unassignedVolunteer);

        assertEquals(1, shelterManager.getShelterVolunteers().size());
        assertTrue(shelterManager.getShelterVolunteers().contains(assignedVolunteer));
    }

@Test
public void testRemoveVolunteerFromEmptyList() {
    ShelterManager shelterManager = createShelterManager();
    Volunteer volunteer = createVolunteer("alex");

    shelterManager.removeShelterVolunteer(volunteer);

    assertTrue(shelterManager.getShelterVolunteers().isEmpty());
    }

private Volunteer createVolunteer(String username) {
    return new Volunteer(
        username,
        "Smith",
        LocalDate.of(1995, 5, 15),
        username + "@example.com",
        "password",
        username,
        new Location("456 Main St", "Columbia", "SC", 29201)
    );
    }
}
