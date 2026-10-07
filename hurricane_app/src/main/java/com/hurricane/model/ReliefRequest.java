package com.hurricane.model;
import java.util.*;

public class ReliefRequest {
    
    private ArrayList<Victim> victims;
    private ArrayList<HAZARD> hazards;
    private String photo;
    private ArrayList<ASSISTANCETYPE> assistanceTypes;
    private Status status;
    private String description;
    private String phoneNumber;
    private UUID id;
    private Location location;
    private boolean isAccepted;

    public ReliefRequest(ArrayList<Victim> victims, ArrayList<HAZARD> hazards, String photo, ArrayList<ASSISTANCETYPE> assistanceTypes, Status status, String description, String phoneNumber, UUID id, Location location) {
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

    public void addHazard(HAZARD hazard) {
        hazards.add(hazard);
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void addAssistanceType(ASSISTANCETYPE assistanceType) {
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

}
