package com.hurricane.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Shelter {
    private String shelterName;
    private ArrayList<Filter> filters;
    private ArrayList<ShelterManager> shelterManagers;
    private int currentCapacity;
    private List<Person> residents;
    private Location location;
    private UUID id;

    public Shelter(String shelterName, int currentCapacity, Location location) {
        this.shelterName = shelterName;
        this.currentCapacity = currentCapacity;
        this.location = location;
        this.filters = new ArrayList<>();
        this.shelterManagers = new ArrayList<>();
        this.residents = new ArrayList<>();
        this.id = UUID.randomUUID();
    }

    public void setCapacity(int capacity) {
        currentCapacity = capacity;
    }

    public int getAvailableSpaces() {
        return currentCapacity - residents.size();
    }

    public UUID getId() {
        return id;
    }
}