package com.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.hurricane.model.*;

public class ReliefRequestTest {
    private ReliefRequest request;
    private UUID id;
    private Location location;

    @Before
    public void setUp() {
        id = UUID.randomUUID();
        location = new Location("123 Main St", "Columbia", "SC", 29201);

        request = new ReliefRequest(
            "mlopez94",
            new ArrayList<Victim>(),
            new ArrayList<Hazard>(),
            "damage.jpg",
            new ArrayList<AssistanceType>(),
            Status.AWAITING_ASSISTANCE,
            "Need medical help",
            "1234567890",
            id,
            location
        );
    }

    @Test
    public void createValidReliefRequest() {
        assertEquals("mlopez94", request.getUserName());
        assertEquals("Need medical help", request.getDescription());
        assertEquals("1234567890", request.getPhoneNumber());
        assertEquals(id, request.getId());
        assertEquals(location, request.getLocation());
        assertEquals(Status.AWAITING_ASSISTANCE, request.getStatus());
        assertEquals("damage.jpg", request.getPhoto());
        assertTrue(request.getVictims().isEmpty());
        assertTrue(request.getHazards().isEmpty());
        assertTrue(request.getAssistanceTypes().isEmpty());
        assertFalse(request.isAccepted());
    }

    @Test
    public void addVictims() {
        Victim first = new Victim("John", VictimStatus.ALRIGHT, 42);
        Victim second = new Victim("Jane", VictimStatus.TRAPPED, 25);

        request.addVictim(first);
        request.addVictim(second);

        assertEquals(2, request.getVictims().size());
        assertEquals(first, request.getVictims().get(0));
        assertEquals(second, request.getVictims().get(1));
    }

    @Test
    public void addHazards() {
        request.addHazard(Hazard.FLOODING);
        request.addHazard(Hazard.FIRE);

        assertEquals(2, request.getHazards().size());
        assertTrue(request.getHazards().contains(Hazard.FLOODING));
        assertTrue(request.getHazards().contains(Hazard.FIRE));
    }

    @Test
    public void addAssistanceTypes() {
        request.addAssistanceType(AssistanceType.MEDICAL);
        request.addAssistanceType(AssistanceType.DEBRIS_REMOVAL);

        assertEquals(2, request.getAssistanceTypes().size());
        assertTrue(request.getAssistanceTypes().contains(AssistanceType.MEDICAL));
        assertTrue(request.getAssistanceTypes().contains(AssistanceType.DEBRIS_REMOVAL));
    }

    @Test
    public void updateDescription() {
        request.setDescription("Water is rising");

        assertEquals("Water is rising", request.getDescription());
    }

    @Test
    public void updatePhoto() {
        request.setPhoto("updated.jpg");

        assertEquals("updated.jpg", request.getPhoto());
    }

    @Test
    public void updateStatus() {
        request.setStatus(Status.IN_PROGRESS);
        assertEquals(Status.IN_PROGRESS, request.getStatus());

        request.setStatus(Status.COMPLETED);
        assertEquals(Status.COMPLETED, request.getStatus());
    }

    @Test
    public void updateAccepted() {
        request.setAccepted(true);
        assertTrue(request.isAccepted());

        request.setAccepted(false);
        assertFalse(request.isAccepted());
    }

    @Test
    public void rejectNullVictim() {
        request.addVictim(null);

        assertFalse(request.getVictims().contains(null));
    }

    @Test
    public void rejectNullStatus() {
        request.setStatus(null);

        assertNotNull(request.getStatus());
    }

    @Test
    public void rejectNullUsername() {
        ReliefRequest invalidRequest = new ReliefRequest(
            null,
            new ArrayList<Victim>(),
            new ArrayList<Hazard>(),
            "damage.jpg",
            new ArrayList<AssistanceType>(),
            Status.AWAITING_ASSISTANCE,
            "Need medical help",
            "1234567890",
            id,
            location
        );

        assertNotNull(invalidRequest.getUserName());
    }
}