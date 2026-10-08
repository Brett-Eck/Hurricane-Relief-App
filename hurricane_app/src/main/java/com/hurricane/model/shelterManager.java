package com.hurricane.model;

import java.util.ArrayList;

public class ShelterManager {
    private ArrayList<Volunteer> shelterVolunteers;

    public ShelterManager() {
        shelterVolunteers = new ArrayList<>();
    }

    public void addShelterVolunteer(Volunteer volunteer) {
        shelterVolunteers.add(volunteer);
    }

    public void removeShelterVolunteer(Volunteer volunteer) {
        shelterVolunteers.remove(volunteer);
    }

    public ArrayList<Volunteer> getShelterVolunteers() {
        return shelterVolunteers;
    }

    public void updateShelterCapacity(Shelter shelter, int capacity) {
        shelter.setCapacity(capacity);
    }
}   