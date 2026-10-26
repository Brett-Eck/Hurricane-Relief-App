package com.hurricane.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Represents a shelter with its capacity, occupancy,
 * location, filters, and assigned managers.
 */
public class Shelter {
    private String shelterName;
    private ArrayList<Filter> filters;
    private ArrayList<ShelterManager> shelterManagers;
    private int capacity;
    private int occupancy;
    private Location location;
    private Availability availability;
    private UUID id;

    /**
     * Creates a shelter with its name, capacity, and location.
     *
     * @param shelterName the name of the shelter
     * @param capacity the maximum capacity
     * @param location the shelter's location
     */
    public Shelter(String shelterName, int capacity, Location location) {
        this.shelterName = shelterName;
        this.capacity = capacity;
        this.occupancy = 0;
        this.location = location;
        this.filters = new ArrayList<>();
        this.shelterManagers = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    /**
     * Gets the shelter's name.
     *
     * @return the shelter name
     */
    public String getShelterName() {
        return shelterName;
    }

    /**
     * Updates the shelter's name.
     *
     * @param shelterName the new shelter name
     */
    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    /**
     * Gets the filters associated with the shelter.
     *
     * @return the list of filters
     */
    public ArrayList<Filter> getFilters() {
        return filters;
    }

    /**
     * Adds a filter to the shelter.
     *
     * @param filter the filter to add
     */
    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    /**
     * Gets the managers assigned to the shelter.
     *
     * @return the list of shelter managers
     */
    public ArrayList<ShelterManager> getShelterManagers() {
        return shelterManagers;
    }

    /**
     * Adds a manager to the shelter.
     *
     * @param shelterManager the manager to add
     */
    public void addShelterManager(ShelterManager shelterManager) {
        this.shelterManagers.add(shelterManager);
    }

    /**
     * Gets the shelter's maximum capacity.
     *
     * @return the shelter capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Updates the shelter's capacity.
     *
     * @param currentCapacity the new capacity
     */
    public void setCurrentCapacity(int currentCapacity) {
        this.capacity = currentCapacity;
    }

    /**
     * Sets the shelter's capacity.
     *
     * @param capacity the new capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Updates the shelter's current occupancy.
     *
     * @param currentOccupancy the new occupancy
     */
    public void setCurrentOccupancy(int currentOccupancy) {
        this.occupancy = currentOccupancy;
    }

    /**
     * Gets the shelter's current occupancy.
     *
     * @return the number of occupants
     */
    public int getOccupancy() {
        return occupancy;
    }

    /**
     * Gets the shelter's availability.
     *
     * @return the availability
     */
    public Availability getAvailability() {
        return availability;
    }

    /**
     * Gets the shelter's location.
     *
     * @return the shelter location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the shelter's unique ID.
     *
     * @return the shelter ID
     */
    public UUID getId() {
        return id;
    }
}
