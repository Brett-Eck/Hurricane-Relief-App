package com.hurricane.model;

import java.util.ArrayList;

public class ShelterList {
    private static final ShelterList shelterList = new ShelterList();

    private ArrayList<Shelter> shelters;

    public ShelterList() {
        shelters = new ArrayList<>();
    }

    public static ShelterList getInstance() {
        return shelterList;
    }

    public Shelter getShelter(String shelterName, Location location) {
        for (Shelter shelter : shelters) {
            Location shelterLocation = shelter.getLocation();

            if (shelter.getShelterName().equals(shelterName) && shelterLocation != null && location != null && shelterLocation.getZipCode() == location.getZipCode()) {
                return shelter;
            }
        }
        return null;
    }

    public ArrayList<Shelter> getShelters() {
        return new ArrayList<>(shelters);
    }

    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }
}