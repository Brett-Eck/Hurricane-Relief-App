package com.hurricane.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Shelter {
    private String shelterName;
    private ArrayList<Filter> filters;
    private ArrayList<ShelterManager> shelterManagers;
    private int currentCapacity;
    private Location location;
    private Availability availability;
    private UUID id;

    public Shelter(String shelterName, int currentCapacity, Location location) {
        this.shelterName = shelterName;
        this.currentCapacity = currentCapacity;
        this.location = location;
        this.filters = new ArrayList<>();
        this.shelterManagers = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public String getShelterName() {
        return shelterName;
    }

    public void setShelterName(String shelterName) {
        this.shelterName = shelterName;
    }

    public ArrayList<Filter> getFilters() {
        return filters;
    }

    public void addFilter(Filter filter) {
        this.filters.add(filter);
    }

    public ArrayList<ShelterManager> getShelterManagers() {
        return shelterManagers;
    }

    public void addShelterManager(ShelterManager shelterManager) {
        this.shelterManagers.add(shelterManager);
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public void setCapacity(int capacity) {
        currentCapacity = capacity;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getId() {
        return id;
    }
}