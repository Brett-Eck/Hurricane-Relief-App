package com.hurricane.model;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Current Admin Stub
 * Admin
 */
public class Admin extends User {
    private ArrayList<Volunteer> volunteers;
    private ArrayList<ReliefRequest> activeReliefRequests;
    private ArrayList<Shelter> currentShelterStatus;
    private Hurricane currentHurricaneStatus;
    private UUID id;

    public void addVolunteer(Volunteer volunteer){
        
    }

    public void removeVolunteer(Volunteer volunteer){
    
    }
    
    public void setCurrentHurricane(Hurricane hurricane){
        
    }

    public void updateHurricane(Hurricane hurricane, Location location, int category){
    
    }


}
