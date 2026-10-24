package com.hurricane.model;

import java.util.ArrayList;

public class ShelterList {
    private static final ShelterList shelterList = new ShelterList();

    private ArrayList<Shelter> shelters = new ArrayList<>();

    public ShelterList() {
        shelters = new DataLoader().getShelters();
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

    public ArrayList<Shelter> findShelters(ArrayList<Filter> requestedFilters) {
        ArrayList<Shelter> matches = new ArrayList<>();

        for (Shelter shelter : shelters) {
            if (shelter.getFilters().containsAll(requestedFilters) && shelter.getFilters().contains(Filter.OPEN_CAPACITY)) {
                matches.add(shelter);
            }
        }

    return matches;
}

    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    public void addShelter(Shelter shelter) {
        shelters.add(shelter);
    }

    public void removeShelter(Shelter shelter) {
        shelters.remove(shelter);
    }

    
}