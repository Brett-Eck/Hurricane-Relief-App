package com.hurricane.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ShelterManager extends User {
    private ArrayList<Volunteer> shelterVolunteers;

    public ShelterManager(String firstName, String lastName, LocalDate birthDate, String email, String password, String username) {
        super(firstName, lastName, birthDate, email, password, username);
        this.shelterVolunteers = new ArrayList<>();
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
        if (shelter == null) {
            throw new IllegalArgumentException("Shelter cannot be null");
        }
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        shelter.setCapacity(capacity);
    }
}   
