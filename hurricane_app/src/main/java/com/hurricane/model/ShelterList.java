package com.hurricane.model;

import java.util.ArrayList;

public class ShelterList {
    private static final ShelterList shelterList = new ShelterList();

    private ArrayList<Shelter> shelters = new ArrayList<>();

    public ShelterList() {
        shelters.add(new Shelter("Shelter A", 150, new Location("123 Main St", "Anytown", "State", 12345)));
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
        return shelters;
    }

    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }
}