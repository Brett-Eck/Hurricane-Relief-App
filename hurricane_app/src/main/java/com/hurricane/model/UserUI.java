
package com.hurricane.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

public class UserUI {
    private UserSystem userSystem = new UserSystem();

    public static void main(String[] args){
        UserUI userUI = new UserUI();
        userUI.run();
    }

    public void run(){
        scenario1();
        scenario2();
        scenario3();
        scenario4();
        scenario7();
        scenario5();
        scenario6();
        scenario8();
        scenario9();


    }

    public void scenario1(){
        userSystem.login("greggoat", "passwordevilmode");
        if (userSystem.login("greggoat", "passwordevilmode") != null){
            System.out.println(userSystem.getCurrentUser().getFirstName() + " " + userSystem.getCurrentUser().getLastName());
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: user not found or password incorrect");
        }
    }

    public void scenario2(){
        userSystem.signup("John", "Doe", LocalDate.of(1995, 5, 15), "johndoe", "password123", "jondoe@example.com");
        if (userSystem.login("johndoe", "password123") != null){
            System.out.println(userSystem.getCurrentUser().getFirstName() + " " + userSystem.getCurrentUser().getLastName());
            System.out.println("Signup successful");
        } else {
            System.out.println("Signup failed");
        }
    }

    public void scenario3(){
        userSystem.login("greggoat", "passwordevilmode");
        if (userSystem.login("greggoat", "passwordevilmode") != null){
            System.out.println(userSystem.getUser().getFirstName() + " " + userSystem.getUser().getLastName());
            System.out.println("Login successful");
        } else {
            System.out.println("Login failed: user not found or password incorrect");
        }
        for (Shelter shelter : userSystem.getShelters()){
            System.out.println(shelter.getShelterName());
        }

    }
    public void scenario4(){
        ArrayList<Victim> victims = new ArrayList<>();
        victims.add(new Victim("John", VictimStatus.MAJOR_INJURY));

        ArrayList<Hazard> hazards = new ArrayList<>();

        ArrayList<AssistanceType> assistanceTypes = new ArrayList<>();
        assistanceTypes.add(AssistanceType.MEDICAL);

        ReliefRequest request = userSystem.createReliefRequest(
                victims,
                hazards,
                "",
                assistanceTypes,
                Status.AWAITING_ASSISTANCE,
                "Victim needs medical assistance",
                "803-555-1234",
                UUID.randomUUID(),
                new Location(29201)
        );

        userSystem.submitReliefRequest(request);

        if (userSystem.getReliefRequests().contains(request)){
            System.out.println("Relief request submitted successfully");
            System.out.println(request.getDescription());
            System.out.println(request.getStatus());
        } else {
            System.out.println("Relief request submission failed");
        }
    }
   public void scenario5(){
        if (userSystem.getReliefRequests().isEmpty()){
            System.out.println("No relief requests available");
            return;
        }

        Volunteer volunteer = new Volunteer(
                "Mike",
                "Smith",
                LocalDate.of(1998, 6, 15),
                "mikesmith@example.com",
                "password123",
                "mikesmith"
        );

        ReliefRequest request = userSystem.getReliefRequests().get(
                userSystem.getReliefRequests().size() - 1
        );

        userSystem.acceptRequest(volunteer, request);

        if (request.isAccepted() && request.getStatus() == Status.IN_PROGRESS){
            System.out.println("Relief request accepted successfully");
            System.out.println(request.getDescription());
            System.out.println(request.getStatus());
        } else {
            System.out.println("Relief request was not accepted");
        }
}

public void scenario6() {
    System.out.println("\nRelief requests needing an assignment:");

    boolean foundRequest = false;

    for (ReliefRequest request : userSystem.getReliefRequests()) {
        if (!request.isAccepted() && request.getStatus() == Status.AWAITING_ASSISTANCE) {

            System.out.println("ID: " + request.getId() + " | ZIP: " + request.getLocation().getZipCode() + " | Description: " + request.getDescription());
            foundRequest = true;
        }
    }
    if (!foundRequest) {
        System.out.println("No relief requests need an assignment.");
    }
}

public void scenario7() {
    ArrayList<Victim> victims = new ArrayList<>(
            Arrays.asList(new Victim("Jane Doe", VictimStatus.MINOR_INJURY)));

    ArrayList<Hazard> hazards = new ArrayList<>(
            Arrays.asList(Hazard.FLOODING, Hazard.DEBRIS));

    ArrayList<AssistanceType> assistanceTypes = new ArrayList<>(
            Arrays.asList(AssistanceType.MEDICAL,
                    AssistanceType.TRANSPORTAION));

    ReliefRequest request = userSystem.createReliefRequest(victims, hazards,null, assistanceTypes, Status.AWAITING_ASSISTANCE, "Two people need medical assistance after flooding.", "843-555-0123", UUID.randomUUID(), new Location(29401)
    );

    userSystem.submitReliefRequest(request);

    System.out.println("\nRelief request created successfully.");
    System.out.println("Request ID: " + request.getId());
}

public void scenario8() {
    System.out.println("\nAll relief requests:");

    ArrayList<ReliefRequest> requests =
            userSystem.getReliefRequests();

    if (requests.isEmpty()) {
        System.out.println("No relief requests available.");
        return;
    }

    for (ReliefRequest request : requests) {
        System.out.println("ID: " + request.getId());
        System.out.println("Description: " + request.getDescription());
        System.out.println("ZIP: " + request.getLocation().getZipCode());
        System.out.println("Status: " + request.getStatus());
        System.out.println();
    }
}

public void scenario9() {
    System.out.println("\nNearest request using hardcoded demo distances:");

    Location userLocation = new Location(29210);

    ReliefRequest nearest =
            userSystem.findNearestReliefRequest(userLocation);

    if (nearest == null) {
        System.out.println("No request has a known demo distance.");
        return;
    }

    System.out.println("User ZIP: " + userLocation.getZipCode());
    System.out.println("Nearest request ID: " + nearest.getId());
    System.out.println("Description: " + nearest.getDescription());
    System.out.println("Request ZIP: "
            + nearest.getLocation().getZipCode());
}


}