
package com.hurricane.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a shelter manager who manages volunteers
 * and can update shelter capacity.
 */
public class ShelterManager extends User {
    private ArrayList<Volunteer> shelterVolunteers;

    /**
     * Creates a shelter manager with their personal information.
     *
     * @param firstName the manager's first name
     * @param lastName the manager's last name
     * @param birthDate the manager's birth date
     * @param email the manager's email
     * @param password the manager's password
     * @param username the manager's username
     * @param location the manager's location
     */
    public ShelterManager(String firstName, String lastName, LocalDate birthDate, String email, String password, String username, Location location) {
        super(firstName, lastName, birthDate, email, password, username, location);
        this.shelterVolunteers = new ArrayList<>();
    }

    /**
     * Adds a volunteer to the shelter.
     *
     * @param volunteer the volunteer to add
     */
    public void addShelterVolunteer(Volunteer volunteer) {
        shelterVolunteers.add(volunteer);
    }

    /**
     * Removes a volunteer from the shelter.
     *
     * @param volunteer the volunteer to remove
     */
    public void removeShelterVolunteer(Volunteer volunteer) {
        shelterVolunteers.remove(volunteer);
    }

    /**
     * Gets the volunteers assigned to the shelter.
     *
     * @return the list of shelter volunteers
     */
    public ArrayList<Volunteer> getShelterVolunteers() {
        return shelterVolunteers;
    }

    /**
     * Updates a shelter's capacity after checking the values.
     *
     * @param shelter the shelter to update
     * @param capacity the new capacity
     * @throws IllegalArgumentException if the shelter is null or capacity is negative
     */
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
