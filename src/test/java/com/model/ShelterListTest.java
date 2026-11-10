package com.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.*;

import com.hurricane.model.*;

public class ShelterListTest {
    private ShelterList shelters;
    private ArrayList<Shelter> shelterList;
    private Location location;
    private Shelter shelter;

    @Before
    public void setUp() {
        shelters = new ShelterList();
        shelterList = shelters.getShelters();
        shelterList.clear();

        location = new Location(
            "123 Main St", "Columbia", "SC", 29201
        );

        shelter = new Shelter("Columbia Shelter", 100, location);
        shelters.addShelter(shelter);
    }

    @Test
    public void testSameInstance() {
        ShelterList firstList = ShelterList.getInstance();
        ShelterList secondList = ShelterList.getInstance();

        assertEquals(firstList, secondList);
    }

    @Test
    public void testValidShelter() {
        Location searchLocation = new Location(
            "123 Main St", "Columbia", "SC", 29201
        );

        Shelter result = shelters.getShelter(
            "Columbia Shelter", searchLocation
        );

        assertEquals(shelter, result);
    }

    @Test
    public void testInvalidShelterName() {
        Shelter result = shelters.getShelter(
            "Missing Shelter", location
        );

        assertNull(result);
    }

    @Test
    public void testInvalidZipCode() {
        Location wrongLocation = new Location(
            "123 Main St", "Columbia", "SC", 29205
        );

        Shelter result = shelters.getShelter(
            "Columbia Shelter", wrongLocation
        );

        assertNull(result);
    }

    @Test
    public void testNullLocation() {
        Shelter result = shelters.getShelter(
            "Columbia Shelter", null
        );

        assertNull(result);
    }

    @Test
    public void testShelterWithoutLocation() {
        Shelter secondShelter = new Shelter(
            "No Location Shelter", 50, null
        );
        shelters.addShelter(secondShelter);

        Shelter result = shelters.getShelter(
            "No Location Shelter", location
        );

        assertNull(result);
    }

    @Test
    public void testEmptyShelterList() {
        shelterList.clear();

        Shelter result = shelters.getShelter(
            "Columbia Shelter", location
        );

        assertNull(result);
    }

    @Test
    public void testAddShelter() {
        Shelter secondShelter = new Shelter(
            "Five Points Super Secret Shelter", 50,
            new Location("456 Harden St", "Columbia", "SC", 29205)
        );

        shelters.addShelter(secondShelter);

        ArrayList<Shelter> expected = new ArrayList<>();
        expected.add(shelter);
        expected.add(secondShelter);

        assertEquals(expected, shelterList);
    }

    @Test
    public void testRemoveShelter() {
        shelters.removeShelter(shelter);

        assertEquals(0, shelterList.size());
    }

    @Test
    public void testRemoveMissingShelter() {
        Shelter missingShelter = new Shelter(
            "Missing Shelter", 50, location
        );

        shelters.removeShelter(missingShelter);

        ArrayList<Shelter> expected = new ArrayList<>();
        expected.add(shelter);

        assertEquals(expected, shelterList);
    }

    @Test
    public void testValidFilters() {
        shelter.addFilter(Filter.PET_FRIENDLY);
        shelter.addFilter(Filter.FOOD);
        shelter.addFilter(Filter.OPEN_CAPACITY);

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(Filter.PET_FRIENDLY);
        filters.add(Filter.FOOD);

        ArrayList<Shelter> result = shelters.findShelters(filters);

        ArrayList<Shelter> expected = new ArrayList<>();
        expected.add(shelter);

        assertEquals(expected, result);
    }

    @Test
    public void testMissingRequestedFilter() {
        shelter.addFilter(Filter.PET_FRIENDLY);
        shelter.addFilter(Filter.OPEN_CAPACITY);

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(Filter.PET_FRIENDLY);
        filters.add(Filter.FOOD);

        ArrayList<Shelter> result = shelters.findShelters(filters);

        assertEquals(0, result.size());
    }

    @Test
    public void testMissingOpenCapacity() {
        shelter.addFilter(Filter.PET_FRIENDLY);

        ArrayList<Filter> filters = new ArrayList<>();
        filters.add(Filter.PET_FRIENDLY);

        ArrayList<Shelter> result = shelters.findShelters(filters);

        assertEquals(0, result.size());
    }

    @Test
    public void testEmptyFilters() {
        shelter.addFilter(Filter.OPEN_CAPACITY);

        Shelter secondShelter = new Shelter(
            "Closed Shelter", 50, location
        );
        shelters.addShelter(secondShelter);

        ArrayList<Filter> filters = new ArrayList<>();

        ArrayList<Shelter> result = shelters.findShelters(filters);

        ArrayList<Shelter> expected = new ArrayList<>();
        expected.add(shelter);

        assertEquals(expected, result);
    }
}