package com.hurricane.model;

import java.util.ArrayList;

/**
 * Manages the shelters in the system, including finding,
 * adding, removing, and saving shelters.
 */
public class ShelterList {
    private static final ShelterList shelterList = new ShelterList();
    private final ArrayList<Shelter> shelters;
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();

    /**
     * Creates the shelter list and loads existing shelters.
     */
    public ShelterList() {
        shelters = dataLoader.getShelters();
    }

    /**
     * Gets the single instance of ShelterList.
     *
     * @return the ShelterList instance
     */
    public static ShelterList getInstance() {
        return shelterList;
    }

    /**
     * Finds a shelter by its name and ZIP code.
     *
     * @param shelterName the shelter name to search for
     * @param location the location to check
     * @return the matching shelter, or null if not found
     */
    public Shelter getShelter(String shelterName, Location location) {
        for (Shelter shelter : shelters) {
            Location shelterLocation = shelter.getLocation();

            if (shelter.getShelterName().equals(shelterName) && shelterLocation != null && location != null && shelterLocation.getZipCode() == location.getZipCode()) {
                return shelter;
            }
        }
        return null;
    }

    /**
     * Finds shelters that match the requested filters and have open capacity.
     *
     * @param requestedFilters the filters to search by
     * @return the list of matching shelters
     */
    public ArrayList<Shelter> findShelters(ArrayList<Filter> requestedFilters) {
        ArrayList<Shelter> matches = new ArrayList<>();

        for (Shelter shelter : shelters) {
            if (shelter.getFilters().containsAll(requestedFilters) && shelter.getFilters().contains(Filter.OPEN_CAPACITY)) {
                matches.add(shelter);
            }
        }

        return matches;
    }

    /**
     * Gets all shelters in the system.
     *
     * @return the list of shelters
     */
    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    /**
     * Adds a shelter to the list.
     *
     * @param shelter the shelter to add
     */
    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }

    /**
     * Removes a shelter from the list.
     *
     * @param shelter the shelter to remove
     */
    public void removeShelter(Shelter shelter) {
        shelters.remove(shelter);
    }

    /**
     * Saves the current shelters.
     *
     * @return true after saving the shelters
     */
    public boolean saveShelters() {
        dataWriter.saveShelters(shelters);
        return true;
    }
}