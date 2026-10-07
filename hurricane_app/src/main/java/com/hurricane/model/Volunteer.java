package com.hurricane.model;

import java.util.ArrayList;

public class Volunteer extends User {

    private ArrayList<TOOL> tools;
    private ArrayList<VEHICLE> vehicles;
    private ArrayList<CERTIFICATION> certifications;


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

    public ArrayList<TOOL> getTools() {
        return tools;
    }

    public ArrayList<VEHICLE> getVehicles() {
        return vehicles;
    }

    public ArrayList<CERTIFICATION> getCertifications() {
        return certifications;
    }

    public void addTool(TOOL tool) {
        this.tools.add(tool);
    }

    public void addVehicle(VEHICLE vehicle) {
        this.vehicles.add(vehicle);
    }

    public void addCertification(CERTIFICATION certification) {
        this.certifications.add(certification);
    }
}