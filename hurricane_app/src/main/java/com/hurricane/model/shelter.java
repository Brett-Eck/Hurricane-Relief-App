package com.hurricane.model;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.UUID;

public class Shelter {
    private String shelterName;
    private ArrayList<FILTER> filters;
    private ArrayList<ShelterManager> shelterManagers;
    private int currentCapacity;
    private Location location;
    private AVAILABILITY availability;
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

    public ArrayList<FILTER> getFilters() {
        return filters;
    }

    public void addFilter(FILTER filter) {
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

    public AVAILABILITY getAvailability() {
        return availability;
    }

    public Location getLocation() {
        return location;
    }

    public UUID getId() {
        return id;
    }
}