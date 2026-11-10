package com.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.hurricane.model.Hurricane;
import com.hurricane.model.HurricaneList;
import com.hurricane.model.Location;

/*
 * AI helped draft the tests and create the table format.
 *
 * | Test | Reasoning |
 * |------|-----------|
 * | testSameInstance | Checking the calls to return the same HurricanList instance. |
 * | testAddHurricane | Adding a hurricane should increase the list size from one to two|
 * | testValidLocation | matching zip should return the same correct hurricane. |
 * | testInvalidZipCode | Zip that doesnt match should return null.|
 * | testNullLocation | Looking for a null location should not crash the code|
 * | testHurricaneWithoutLocation |  hurricane that has no location should be skipped during a search |
 * | testEmptyHurricaneList | Searching an empty list should return null. |
 * | testUpdateLocation | Updating the hurricane should store the new location. |
 * | testUpdateCategory |  Updating the hurricane should return the new category. |
 * | testUpdateWindSpeed | updating the hurricane should store the new wind speed. |
 * | testUpdateDiameter | Updating the hurricane should store the new diameter. |
 * | testUpdateMissingIdLeavesCategoryUnchanged | an unknown ID should leave the existing hurricane's category unchanged. |
 * | testUpdateSecondHurricane |  updating should look for the proper hurricane instead of the very first list item. |
 * | testRemoveHurricane | removing the last hurricane should leave the list empty. |
 * | testRemoveMissingId | Removing an unknown ID should leave the list unchanged. |
 * | testClearingCopyPreservesHurricanes | Clearing the returned copy should preserve the original list. |
 */

public class HurricaneListTest {
    private HurricaneList hurricanes;
    private Location location;
    private Hurricane hurricane;

    @Before
    public void setUp() {
        hurricanes = new HurricaneList();

        for (Hurricane existingHurricane : hurricanes.getHurricanes()) {
            hurricanes.removeHurricane(existingHurricane.getId());
        }

        location = new Location(
            "123 Main St", "Columbia", "SC", 29201
        );

        hurricanes.addHurricane(
            "Helene", location, 3, 120.0, 300.0
        );

        hurricane = hurricanes.getHurricanes().get(0);
    }

    @Test
    public void testSameInstance() {
        HurricaneList firstList = HurricaneList.getInstance();
        HurricaneList secondList = HurricaneList.getInstance();

        assertEquals(firstList, secondList);
    }

    @Test
    public void testAddHurricane() {
        hurricanes.addHurricane(
            "Milton",
            new Location("456 Harden St", "Columbia", "SC", 29205),
            4, 140.0, 250.0
        );

        assertEquals(2, hurricanes.getHurricanes().size());
    }

    @Test
    public void testValidLocation() {
        Location searchLocation = new Location(
            "123 Main St", "Columbia", "SC", 29201
        );

        Hurricane result = hurricanes.getHurricane(searchLocation);

        assertEquals(hurricane, result);
    }

    @Test
    public void testInvalidZipCode() {
        Location wrongLocation = new Location(
            "456 Harden St", "Columbia", "SC", 29205
        );

        Hurricane result = hurricanes.getHurricane(wrongLocation);

        assertNull(result);
    }

    @Test
    public void testNullLocation() {
        Hurricane result = hurricanes.getHurricane(null);

        assertNull(result);
    }

    @Test
    public void testHurricaneWithoutLocation() {
        hurricanes.removeHurricane(hurricane.getId());
        hurricanes.addHurricane(
            "Milton", null, 4, 140.0, 250.0
        );

        Hurricane result = hurricanes.getHurricane(location);

        assertNull(result);
    }

    @Test
    public void testEmptyHurricaneList() {
        hurricanes.removeHurricane(hurricane.getId());

        Hurricane result = hurricanes.getHurricane(location);

        assertNull(result);
    }

    @Test
    public void testUpdateLocation() {
        Location newLocation = new Location(
            "456 Harden St", "Columbia", "SC", 29205
        );

        hurricanes.updateHurricane(
            hurricane.getId(), newLocation, 3, 120.0, 300.0
        );

        assertEquals(newLocation, hurricane.getLocation());
    }

    @Test
    public void testUpdateCategory() {
        hurricanes.updateHurricane(
            hurricane.getId(), location, 4, 120.0, 300.0
        );

        assertEquals(4, hurricane.getCategory());
    }

    @Test
    public void testUpdateWindSpeed() {
        hurricanes.updateHurricane(
            hurricane.getId(), location, 3, 125.0, 300.0
        );

        assertEquals(125.0, hurricane.getWindSpeed(), 0.001);
    }

    @Test
    public void testUpdateDiameter() {
        hurricanes.updateHurricane(
            hurricane.getId(), location, 3, 120.0, 350.0
        );

        assertEquals(350.0, hurricane.getDiameter(), 0.001);
    }

    @Test
    public void testUpdateMissingIdLeavesCategoryUnchanged() {
        UUID missingId = UUID.fromString(
            "00000000-0000-0000-0000-000000000000"
        );

        hurricanes.updateHurricane(
            missingId, location, 5, 160.0, 400.0
        );

        assertEquals(3, hurricane.getCategory());
    }

    @Test
    public void testUpdateSecondHurricane() {
        hurricanes.addHurricane(
            "Milton", location, 4, 140.0, 250.0
        );
        Hurricane secondHurricane = hurricanes.getHurricanes().get(1);

        hurricanes.updateHurricane(
            secondHurricane.getId(), location, 5, 160.0, 400.0
        );

        assertEquals(5, secondHurricane.getCategory());
    }

    @Test
    public void testRemoveHurricane() {
        hurricanes.removeHurricane(hurricane.getId());

        assertEquals(0, hurricanes.getHurricanes().size());
    }

    @Test
    public void testRemoveMissingId() {
        UUID missingId = UUID.fromString(
            "00000000-0000-0000-0000-000000000000"
        );

        hurricanes.removeHurricane(missingId);

        ArrayList<Hurricane> expected = new ArrayList<>();
        expected.add(hurricane);

        assertEquals(expected, hurricanes.getHurricanes());
    }

    @Test
    public void testClearingCopyPreservesHurricanes() {
        ArrayList<Hurricane> copiedList = hurricanes.getHurricanes();

        copiedList.clear();

        ArrayList<Hurricane> expected = new ArrayList<>();
        expected.add(hurricane);

        assertEquals(expected, hurricanes.getHurricanes());
    }
}