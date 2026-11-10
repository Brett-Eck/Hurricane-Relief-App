package com.hurricane.model;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Stores information about a relief request, including victims,
 * hazards, needed assistance, and the current request status.
 */
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

    /**
     * Creates a relief request with the provided information.
     *
     * @param userName the username of the person making the request
     * @param victims the victims involved
     * @param hazards the hazards at the location
     * @param photo the photo associated with the request
     * @param assistanceTypes the types of assistance needed
     * @param status the current status
     * @param description the request description
     * @param phoneNumber the contact phone number
     * @param id the request ID
     * @param location the location of the request
     */
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

    /**
     * Adds a victim to the request.
     *
     * @param victim the victim to add
     */
    public void addVictim(Victim victim) {
        victims.add(victim);
    }

    /**
     * Adds a hazard to the request.
     *
     * @param hazard the hazard to add
     */
    public void addHazard(Hazard hazard) {
        hazards.add(hazard);
    }

    /**
     * Updates the photo for the request.
     *
     * @param photo the new photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Adds a type of assistance needed for the request.
     *
     * @param assistanceType the assistance type to add
     */
    public void addAssistanceType(AssistanceType assistanceType) {
        assistanceTypes.add(assistanceType);
    }

    /**
     * Updates the request status.
     *
     * @param status the new status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Updates the request description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the request status.
     *
     * @return the current status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Gets the request description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the contact phone number.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Gets the request ID.
     *
     * @return the request ID
     */
    public UUID getId() {
        return id;
    }

    /**
     * Gets the location of the request.
     *
     * @return the request location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the victims listed in the request.
     *
     * @return the list of victims
     */
    public ArrayList<Victim> getVictims() {
        return victims;
    }

    /**
     * Updates whether the request has been accepted.
     *
     * @param accepted true if accepted, false otherwise
     */
    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    /**
     * Checks whether the request has been accepted.
     *
     * @return true if accepted, false otherwise
     */
    public boolean isAccepted() {
        return isAccepted;
    }

    /**
     * Gets the username associated with the request.
     *
     * @return the username
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Gets the hazards listed in the request.
     *
     * @return the list of hazards
     */
    public ArrayList<Hazard> getHazards() {
        return hazards;
    }
    /**
     * Gets the photo associated with the request.
     *
     * @return the photo
     */
    public String getPhoto() {
        return photo;
    }
    /**
     * Gets the types of assistance needed.
     *
     * @return the list of assistance types
     */
    public ArrayList<AssistanceType> getAssistanceTypes() {
        return assistanceTypes;
    }


    /**
     * Exports the relief request details to a text file.
     *
     * @param request the relief request to export
     * @return true if the file was written successfully, false otherwise
     */
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
