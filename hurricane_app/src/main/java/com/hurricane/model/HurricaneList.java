package com.hurricane.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Manages hurricanes in the system, including adding,
 * updating, searching, removing, and saving them.
 */
public class HurricaneList {
    private static final HurricaneList hurricaneList = new HurricaneList();
    private ArrayList<Hurricane> hurricanes = new ArrayList<>();
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();

    /**
     * Creates the hurricane list and loads existing hurricanes.
     */
    public HurricaneList() {
        hurricanes = dataLoader.getHurricanes();
    }

    /**
     * Adds a new hurricane to the list.
     *
     * @param hurricaneName the name of the hurricane
     * @param location the hurricane's location
     * @param category the hurricane category
     * @param windSpeed the wind speed
     * @param diameter the hurricane diameter
     */
    public void addHurricane(String hurricaneName, Location location, int category, double windSpeed, double diameter) {
        hurricanes.add(new Hurricane(hurricaneName, location, category, windSpeed, diameter));
    }

    /**
     * Gets the single instance of HurricaneList.
     *
     * @return the HurricaneList instance
     */
    public static HurricaneList getInstance() {
        return hurricaneList;
    }

    /**
     * Updates a hurricane's information using its ID.
     *
     * @param id the ID of the hurricane to update
     * @param newLocation the new location
     * @param newCategory the new category
     * @param newWindSpeed the new wind speed
     * @param newDiameter the new diameter
     */
    public void updateHurricane(UUID id, Location newLocation, int newCategory, double newWindSpeed, double newDiameter) {
        for (Hurricane hurricane : hurricanes) {
            if (hurricane.getId().equals(id)) {
                hurricane.setLocation(newLocation);
                hurricane.setCategory(newCategory);
                hurricane.setWindSpeed(newWindSpeed);
                hurricane.setDiameter(newDiameter);
                return;
            }
        }
    }

    /**
     * Finds a hurricane at a given location using its ZIP code.
     *
     * @param location the location to search for
     * @return the matching hurricane, or null if not found
     */
    public Hurricane getHurricane(Location location) {
    if (location == null) {
        return null;
    }

    for (Hurricane hurricane : hurricanes) {
        Location hurricaneLocation = hurricane.getLocation();

        if (hurricaneLocation != null
                && hurricaneLocation.getZipCode() == location.getZipCode()) {
            return hurricane;
        }
    }

    return null;
}

    /**
     * Gets all hurricanes in the system.
     *
     * @return a copy of the hurricane list
     */
    public ArrayList<Hurricane> getHurricanes() {
        return new ArrayList<>(hurricanes);
    }

    /**
     * Removes a hurricane from the list using its ID.
     *
     * @param id the ID of the hurricane to remove
     */
    public void removeHurricane(UUID id) {
        hurricanes.removeIf(hurricane -> hurricane.getId().equals(id));
    }

    /**
     * Saves the current hurricanes.
     *
     * @return true after saving the hurricanes
     */
    public boolean saveHurricanes() {
        dataWriter.saveHurricanes(hurricanes);
        return true;
    }
}