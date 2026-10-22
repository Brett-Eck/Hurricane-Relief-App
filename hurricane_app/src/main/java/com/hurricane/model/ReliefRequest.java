package com.hurricane.model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ReliefRequest {
    
    private String userName;
    private ArrayList<Victim> victims;
    private ArrayList<Hazard> hazards;
    private String photo;
    private ArrayList<AssistanceType> assistanceTypes;
    private Status status;
    private String description;
    private String phoneNumber;
    private UUID id;
    private Location location;
    private boolean isAccepted;

    public ReliefRequest(String userName, ArrayList<Victim> victims, ArrayList<Hazard> hazards, String photo, ArrayList<AssistanceType> assistanceTypes,
         Status status, String description, String phoneNumber, UUID id, Location location) {
        this.userName = userName;
        this.victims = victims;
        this.hazards = hazards;
        this.photo = photo;
        this.assistanceTypes = assistanceTypes;
        this.status = status;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.id = id;
        this.location = location;
    }

    public void addVictim(Victim victim) {
        victims.add(victim);
    }

    public void addHazard(Hazard hazard) {
        hazards.add(hazard);
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void addAssistanceType(AssistanceType assistanceType) {
        assistanceTypes.add(assistanceType);
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public ArrayList<Victim> getVictims() {
        return victims;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public String getUserName() {
        return userName;
    }
    public ArrayList<Hazard> getHazards() {
        return hazards;
    }
    public String getPhoto() {
        return photo;
    }
    public ArrayList<AssistanceType> getAssistanceTypes() {
        return assistanceTypes;
    }


    public boolean getAllDetails(ReliefRequest request) {
        Path filePath = Path.of("Relief_Request_Details.txt");
        String content = "Relief Request Details for " + request.getUserName() + ":\n" +
                    "Description: " + request.getDescription() + "\n" +
                    "Phone Number: " + request.getPhoneNumber() + "\n" +
                    "Location: " + request.getLocation().getStreet() + ", " + request.getLocation().getCity() + ", " + request.getLocation().getState() + " " + request.getLocation().getZipCode();
                    for (Victim victim : request.getVictims()) {
                        content += "\nVictim: " + victim.getFirstName() + ", Status: " + victim.getVictimStatus() + ", Age: " + victim.getAge();
                    }
                    content += "\nHazards: " + request.getHazards() + "\n" +
                    "Assistance Types: " + request.getAssistanceTypes() + "\n" +
                    "Status: " + request.getStatus() + "\n" +
                    "Photo: " + request.getPhoto() + "\n" +
                    "Request ID: " + request.getId() + "\n";

        try {
            Files.writeString(filePath, content);
            System.out.println("File written successfully!");
            return true;
        } catch (IOException e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
        return false;
    }


}
