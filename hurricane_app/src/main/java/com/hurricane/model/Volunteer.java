package com.hurricane.model;

import java.util.ArrayList;

public class Volunteer extends User {

    private ArrayList<Tools> tools;
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Certifications> certifications;


    public Volunteer(String firstName, String lastName, java.time.LocalDate birthDate,
                     String email, String password, String username) {
        super(firstName, lastName, birthDate, email, password, username);
        this.tools = new ArrayList<>();
        this.vehicles = new ArrayList<>();
        this.certifications = new ArrayList<>();
    }

    public ReliefRequest acceptRequest(ReliefRequest request) {
        if (request != null && !request.isAccepted()) {
            request.setAccepted(true);
            return request;
        }
        return null;
    }

    public ArrayList<Tools> getTools() {
        return tools;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public ArrayList<Certifications> getCertifications() {
        return certifications;
    }

    public void addTool(Tools tool) {
        this.tools.add(tool);
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addCertification(Certifications certification) {
        this.certifications.add(certification);
    }
}