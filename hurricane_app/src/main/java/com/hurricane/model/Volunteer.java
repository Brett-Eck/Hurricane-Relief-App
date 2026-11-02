package com.hurricane.model;

import java.util.ArrayList;

/**
 * Represents a volunteer who can accept relief requests
 * and has tools, vehicles, and certifications.
 */
public class Volunteer extends User {

    private ArrayList<Tools> tools;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Certification> certifications;


    /**
     * Creates a volunteer with their personal information.
     *
     * @param firstName the volunteer's first name
     * @param lastName the volunteer's last name
     * @param birthDate the volunteer's birth date
     * @param email the volunteer's email
     * @param password the volunteer's password
     * @param username the volunteer's username
     * @param location the volunteer's location
     */
    public Volunteer(String firstName, String lastName, java.time.LocalDate birthDate,
                     String email, String password, String username, Location location) {
        super(firstName, lastName, birthDate, email, password, username, location);
        this.tools = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.certifications = new ArrayList<>();
    }

    /**
     * Accepts a relief request if it has not already been accepted.
     *
     * @param request the relief request to accept
     * @return the accepted request, or null if it cannot be accepted
     */
    public ReliefRequest acceptRequest(ReliefRequest request) {
        if (request != null && !request.isAccepted()) {
            request.setAccepted(true);
            return request;
        }
        return null;
    }

    /**
     * Gets the volunteer's tools.
     *
     * @return the list of tools
     */
    public ArrayList<Tools> getTools() {
        return tools;
    }

    /**
     * Gets the volunteer's vehicles.
     *
     * @return the list of vehicles
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    /**
     * Gets the volunteer's certifications.
     *
     * @return the list of certifications
     */
    public ArrayList<Certification> getCertifications() {
        return certifications;
    }

    /**
     * Adds a tool to the volunteer's list.
     *
     * @param tool the tool to add
     */
    public void addTool(Tools tool) {
        this.tools.add(tool);
    }

    /**
     * Adds a vehicle to the volunteer's list.
     *
     * @param vehicle the vehicle to add
     */
    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    /**
     * Adds a certification to the volunteer's list.
     *
     * @param certification the certification to add
     */
    public void addCertification(Certification certification) {
        this.certifications.add(certification);
    }
}