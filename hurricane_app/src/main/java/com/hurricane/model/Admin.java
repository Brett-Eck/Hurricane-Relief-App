// package com.hurricane.model;
// import java.util.ArrayList;
// import java.util.UUID;
// import java.time.LocalDate;

// /**
//  * Current Admin Stub
//  * Admin
//  */
// public class Admin extends User {
//     private ArrayList<Volunteer> volunteers;
//     private ArrayList<ReliefRequest> activeReliefRequests;
//     private ArrayList<Shelter> currentShelterStatus;
//     private Hurricane currentHurricaneStatus;

//     public Admin(String firstName, String lastName, LocalDate birthDate, String email, String password, String username) {
//         super(firstName, lastName, birthDate, email, password, username);
//         this.volunteers = new ArrayList<>();
//         this.activeReliefRequests = new ArrayList<>();
//         this.currentShelterStatus = new ArrayList<>();
//     }

//     public void addVolunteer(Volunteer volunteer){
//         volunteers.add(volunteer);
//     }

//     public void removeVolunteer(Volunteer volunteer){
//         volunteers.remove(volunteer);
//     }
    
//     public void setCurrentHurricane(Hurricane hurricane){
//         if (hurricane != null) {
//             this.currentHurricaneStatus = hurricane;
//         } else {
//             throw new IllegalArgumentException("Hurricane cannot be null");
//         }
//     }

//     public void updateHurricane(Hurricane hurricane, Location location, int category){
//         hurricane.setLocation(location);
//         hurricane.setCategory(category);
//     }

//     public void updateShelterStatus(Shelter shelter, int capacity, int currentOccupancy){
//         shelter.setCapacity(capacity);
//         shelter.setCurrentOccupancy(currentOccupancy);
//     }





// }
