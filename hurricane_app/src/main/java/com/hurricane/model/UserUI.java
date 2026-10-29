package com.hurricane.model;

import com.hurricane.location.Address;
import com.hurricane.location.MapTools;

import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Runs the demo scenarios for the hurricane relief application.
 */
public class UserUI {
    private UserSystem userSystem = new UserSystem();

    ArrayList<Filter> requestedFilters = new ArrayList<>();

    /**
     * Starts the application scenarios.
     *
     * @param args command line arguments
     */
    public static void main(String[] args){
        UserUI userUI = new UserUI();
        userUI.run();
    }

     
/**
 * Runs the Sophie and Rosa scenarios.
 */
public void run() {
    // scenario1();
    // scenario2();
    // scenario3();
    // scenario4();
    // scenario7();
    // scenario5();
    // scenario6();
    // scenario8();
    // scenario9();
    // scenario10();
    // scenario11();

    sophieScenario();
    rosaScenario();

    /**
     * Tests whether volunteers, relief requests, and
     * shelters are loading correctly from the JSON files.
     * UNCOMMENT THE CODE below to RUN these tests.
     */

    // System.out.println("Volunteers loaded:");
    // for (Volunteer volunteer : userSystem.getVolunteers()) {
    //     System.out.println(volunteer.getFirstName() + " "
    //             + volunteer.getLastName() + " - "
    //             + volunteer.getVehicles());
    // }

    // System.out.println("Requests loaded: "
    //         + userSystem.getReliefRequests().size());

    // System.out.println("Shelters loaded: "
    //         + userSystem.getShelters().size());
}

    

    ArrayList<Shelter> matches = userSystem.findShelters(requestedFilters);


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
        userSystem.signup("John", "Doe", LocalDate.of(1995, 5, 15), "johndoe", "password123", "jondoe@example.com", new Location("789 Pine St", "Greenville", "SC", 29601));
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
            System.out.println(userSystem.getCurrentUser().getFirstName() + " " + userSystem.getCurrentUser().getLastName());
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
        victims.add(new Victim("John", VictimStatus.MAJOR_INJURY, 32));

        ArrayList<Hazard> hazards = new ArrayList<>();

        ArrayList<AssistanceType> assistanceTypes = new ArrayList<>();
        assistanceTypes.add(AssistanceType.MEDICAL);

        ReliefRequest request = userSystem.createReliefRequest(
                "jsmith",
                victims,
                hazards,
                "",
                assistanceTypes,
                Status.AWAITING_ASSISTANCE,
                "Victim needs medical assistance",
                "803-555-1234",
                UUID.randomUUID(),
                new Location("123 Main St", "Lexington", "SC", 12345)
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
                "mikesmith",
                new Location("456 Oak Ave", "Anytown", "SC", 29401)
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
            Arrays.asList(new Victim("Jane Doe", VictimStatus.MINOR_INJURY, 41)));

    ArrayList<Hazard> hazards = new ArrayList<>(
            Arrays.asList(Hazard.FLOODING, Hazard.DEBRIS));

    ArrayList<AssistanceType> assistanceTypes = new ArrayList<>(
            Arrays.asList(AssistanceType.MEDICAL,
                    AssistanceType.TRANSPORTAION));

    ReliefRequest request = userSystem.createReliefRequest("jsmith", victims, hazards,null, assistanceTypes, Status.AWAITING_ASSISTANCE, "Two people need medical assistance after flooding.", "843-555-0123", UUID.randomUUID(), new Location("456 Oak Ave", "Anytown", "SC", 29401)
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

    Location userLocation = new Location("267 Main St", "Lexington", "SC", 29210);

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

public void scenario10() {
    ShelterList shelterList = ShelterList.getInstance();

    Shelter shelter = new Shelter(
            "Columbia Emergency Shelter",
            200,
            new Location("100 Main St", "Columbia", "SC", 29201)
    );

    shelterList.addShelter(shelter);

    if (userSystem.getShelters().contains(shelter)) {
        System.out.println("Shelter registered successfully");
        System.out.println("Shelter: " + shelter.getShelterName());
        System.out.println("Capacity: " + shelter.getCapacity());
    } else {
        System.out.println("Shelter registration failed");
    }
}

public void scenario11() {
    ShelterList shelterList = ShelterList.getInstance();

    Location location = new Location(
            "100 Main St", "Columbia", "SC", 29201
    );

    Shelter shelter = shelterList.getShelter(
            "Columbia Emergency Shelter", location
    );

    if (shelter != null) {
        System.out.println("Shelter found successfully");
        System.out.println("Shelter: " + shelter.getShelterName());
        System.out.println("ZIP: " + shelter.getLocation().getZipCode());
    } else {
        System.out.println("Shelter not found");
    }
}

/**
 * Creates a relief request for Sophie and her family.
 */
public void sophieScenario() {
    userSystem.signup("John", "Smith", LocalDate.of(1980, 3, 14), "jsmith", "sophie123", "jsmith@example.com", new Location("759 King St", "Charleston", "SC", 29403));
    ReliefRequest request = userSystem.createReliefRequest(
        "jsmith",
        new ArrayList<>(Arrays.asList(new Victim("John", VictimStatus.ALRIGHT, 42), new Victim("Sandra", VictimStatus.ALRIGHT,40), new Victim("Sophie", VictimStatus.MINOR_INJURY, 15), new Pet("Buddy", VictimStatus.ALRIGHT, "Dog", 5))),
        null,
        null,
        new ArrayList<>(Arrays.asList(AssistanceType.TRANSPORTAION, AssistanceType.MEDICAL)),
        Status.AWAITING_ASSISTANCE,
        "Three family members and one dog need transportation. Sophie needs medical assistance for asthma.",
        "803-555-9876",
        UUID.randomUUID(),
        new Location("759 King St", "Charleston", "SC", 29403)
    );

    userSystem.submitReliefRequest(request);
    userSystem.getReliefRequests().get(0).getAllDetails(request);
    

    System.out.println(userSystem.getUser("jsmith", "sophie123").getFirstName() + " " + userSystem.getUser("jsmith", "sophie123").getLastName());
    System.out.println(ReliefRequestList.getInstance().getReliefRequest("803-555-9876").getDescription());
}

/**
 * Logs Rosa in and finds a transportation request for her.
 */
public void rosaScenario() {
    Volunteer rosa = null;

    for (Volunteer volunteer : userSystem.getVolunteers()) {
        if (volunteer.getUsername().equals("rdelgado")) {
            rosa = volunteer;
            break;
        }
    }

    if (rosa == null) {
        System.out.println("Rosa not found.");
        return;
    }

    User loggedIn = userSystem.login(rosa.getUsername(), rosa.getPassword());

    if (loggedIn != rosa) {
        System.out.println("Rosa login failed.");
        return;
    }

    System.out.println("Welcome, " + rosa.getFirstName() + " " + rosa.getLastName());
    System.out.println("Vehicles: " + rosa.getVehicles());

    ArrayList<ReliefRequest> open = new ArrayList<>();
    ReliefRequest best = null;
    boolean bestNearby = false;

    for (ReliefRequest request : userSystem.getReliefRequests()) {
        if (request.isAccepted() || request.getStatus() != Status.AWAITING_ASSISTANCE) {
            continue;
        }

        open.add(request);

        if (request.getVictims() == null || request.getVictims().isEmpty()) {
            continue;
        }

        if (!rosa.getVehicles().contains(Vehicle.TRUCK)
                || request.getAssistanceTypes() == null
                || !request.getAssistanceTypes().contains(AssistanceType.TRANSPORTAION)) {
            continue;
        }

        boolean nearby = rosa.getLocation() != null
                && request.getLocation() != null
                && rosa.getLocation().getZipCode() == request.getLocation().getZipCode();

        if (best == null || (nearby && !bestNearby)) {
            best = request;
            bestNearby = nearby;
        }
    }

    System.out.println("Open requests: " + open.size());

    if (best != null) {
        System.out.println("1. RECOMMENDED: " + best.getDescription());
    }

    int number = best == null ? 1 : 2;

    for (ReliefRequest request : open) {
        if (request != best) {
            System.out.println(number++ + ". " + request.getDescription());
        }
    }

    if (best == null) {
        System.out.println("No transportation match found.");
        return;
    }

    System.out.println("Rosa opens the recommended request.");
    System.out.println("Description: " + best.getDescription());
    System.out.println("Assistance: " + best.getAssistanceTypes());
    System.out.println("Status: " + best.getStatus());
    System.out.println("Phone: " + best.getPhoneNumber());
    System.out.println("Reason: Transportation matches Rosa's truck.");

    if (best.getLocation() != null) {
        System.out.println("Request ZIP: " + best.getLocation().getZipCode());
    }

    if (bestNearby) {
        System.out.println("Rosa is in the same ZIP code.");
    }

    if (best.getVictims() != null) {
        for (Victim victim : best.getVictims()) {
            System.out.println(victim.getFirstName()
                    + ", Age: " + victim.getAge()
                    + ", Status: " + victim.getVictimStatus());
        }
    }

    rosaShelterScenario(rosa, best);
}


public void scenario12() {
    System.out.println("\nAll shelters:");

    ArrayList<Shelter> shelters = userSystem.getShelters();

    if (shelters.isEmpty()) {
        System.out.println("No shelters available.");
        return;
    }

    for (Shelter shelter : shelters) {
        System.out.println("Shelter Name: " + shelter.getShelterName());
        System.out.println("Capacity: " + shelter.getCapacity());
        System.out.println("ZIP: " + shelter.getLocation().getZipCode());
        System.out.println();
    }


}


/**
 * Finds a suitable shelter for Rosa's assigned relief request.
 *
 * @param rosa the volunteer helping with the request
 * @param request the request being handled
 */
public void rosaShelterScenario(Volunteer rosa, ReliefRequest request) {
    if (rosa == null || request == null
            || request.getVictims() == null
            || request.getLocation() == null) {
        System.out.println("Volunteer or request details are missing.");
        return;
    }

    if (request.isAccepted()
            || request.getStatus() != Status.AWAITING_ASSISTANCE) {
        System.out.println("This request is no longer available.");
        return;
    }

    System.out.println("Searching "
            + userSystem.getShelters().size() + " shelters.");

    int people = 0;
    int pets = 0;

    for (Victim victim : request.getVictims()) {
        if (victim instanceof Pet) {
            pets++;
        } else {
            people++;
        }
    }

    if (people == 0) {
        System.out.println("No family members are listed.");
        return;
    }

    ArrayList<Filter> filters = new ArrayList<>();
    filters.add(Filter.MEDICAL);

    if (pets > 0) {
        filters.add(Filter.PET_FRIENDLY);
    }

    ArrayList<Shelter> suitableShelters = new ArrayList<>();
    ArrayList<Address> addresses = new ArrayList<>();

    if (!prepareShelterScenario()) {
        return;
    }

    for (Shelter shelter : userSystem.findShelters(filters)) {
        int spaces = shelter.getCapacity() - shelter.getOccupancy();

        if (spaces >= people) {
            suitableShelters.add(shelter);
            addresses.add(toAddress(shelter.getLocation()));
        }
    }

    if (suitableShelters.isEmpty()) {
        System.out.println("No shelters meet the family's needs.");
        return;
    }

    try {
        // The demo can continue without routing, but makes no closest claim.
        Address closest = addresses.get(0);
        if (System.getenv("MAP_API_KEY") == null
                || System.getenv("MAP_API_KEY").isBlank()) {
            System.out.println("Routing unavailable: using the first suitable shelter for this demo, not a verified closest shelter.");
        } else {
            try {
                closest = MapTools.getInstance().findClosestAddress(
                        toAddress(request.getLocation()),
                        addresses.toArray(new Address[0]));
                System.out.println("Shelter selected by driving time using the existing map method.");
            } catch (java.io.IOException | IllegalStateException e) {
                System.out.println("Routing failed: " + e.getMessage());
                System.out.println("Using the first suitable shelter for this demo; closest route not verified.");
            }
        }

        int index = addresses.indexOf(closest);

        if (index < 0) {
            System.out.println("Unable to select a shelter.");
            return;
        }

        Shelter selected = suitableShelters.get(index);

        ShelterManager felix = new ShelterManager(
        "Felix",
        "Rivera",
        LocalDate.of(1985, 6, 15),
        "felix@example.com",
        "felix123",
        "felixmanager",
        selected.getLocation()
        );

     userSystem.getUsers().add(felix);

     selected.addShelterManager(felix);

        userSystem.acceptRequest(rosa, request);

        System.out.println("People needing transportation: " + people);
        System.out.println("Accompanying pets: " + pets);
        System.out.println("Selected shelter: " + selected.getShelterName());
        System.out.println("Shelter address: " + closest);
        System.out.println("Accepted by: " + rosa.getFirstName() + " " + rosa.getLastName());
        System.out.println("Status: " + request.getStatus());

        System.out.println("Rosa attempts to complete the request:");
        completeScenarioRequest(selected, request);
        System.out.println("Status after Rosa's attempt: " + request.getStatus());

        felixShelterScenario(felix, selected, request);

    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Shelter search interrupted.");
    } catch (Exception e) {
        System.out.println("Unable to find a shelter: " + e.getMessage());
    }
    
}

/** Supplies scenario details that the unchanged DataLoader does not read. */
private boolean prepareShelterScenario() {
    Path path = Path.of("json/shelters.json");
    if (!Files.exists(path)) {
        path = Path.of("hurricane_app/json/shelters.json");
    }

    try (FileReader reader = new FileReader(path.toFile())) {
        JSONObject root = (JSONObject) new JSONParser().parse(reader);
        JSONArray entries = (JSONArray) root.get("shelters");

        for (Object entry : entries) {
            JSONObject json = (JSONObject) entry;
            JSONObject location = (JSONObject) json.get("location");
            Shelter shelter = ShelterList.getInstance().getShelter(
                    (String) json.get("shelterName"),
                    new Location("", "", "",
                            ((Number) location.get("zipCode")).intValue()));

            if (shelter == null || !shelter.getFilters().isEmpty()) {
                continue;
            }

            JSONArray filters = (JSONArray) json.get("filters");
            boolean full = false;
            if (filters != null) {
                for (Object value : filters) {
                    if ("FULL_CAPACITY".equals(value)) {
                        full = true;
                    } else {
                        shelter.addFilter(Filter.valueOf((String) value));
                    }
                }
            }

            Number occupancy = (Number) json.get("occupancy");
            if (occupancy != null) {
                shelter.setCurrentOccupancy(occupancy.intValue());
            } else if (full) {
                shelter.setCurrentOccupancy(shelter.getCapacity());
            }
        }
        return true;
    } catch (Exception e) {
        System.out.println("Unable to prepare shelter details: " + e.getMessage());
        return false;
    }
}

/** Role check shared by Rosa's attempt and Felix's completion in this demo. */
private boolean completeScenarioRequest(Shelter shelter, ReliefRequest request) {
    User current = userSystem.getCurrentUser();
    if (!(current instanceof ShelterManager)
            || !shelter.getShelterManagers().contains(current)) {
        System.out.println("Your role does not have permission to complete this relief request.");
        return false;
    }
    if (request.getStatus() != Status.IN_PROGRESS) {
        System.out.println("Only an assigned request can be completed.");
        return false;
    }
    request.setStatus(Status.COMPLETED);
    System.out.println("Relief request status: Complete");
    return true;
}

/**
 * Converts a location into an address for the mapping tools.
 *
 * @param location the location to convert
 * @return the address used by the mapping tools
 */
private Address toAddress(Location location) {
    return new Address(
            location.getStreet(),
            location.getCity(),
            location.getState(),
            String.valueOf(location.getZipCode())
    );
}

public void felixShelterScenario(ShelterManager felix, Shelter shelter, ReliefRequest request) {

    if (felix == null || shelter == null || request == null || request.getVictims() == null) {
        System.out.println("Manager, shelter, or family information is missing.");
        return;
    }

    User loggedIn = userSystem.login(
            felix.getUsername(), felix.getPassword());

    if (!(loggedIn instanceof ShelterManager) || !loggedIn.getUsername().equals(felix.getUsername())) {
        System.out.println("A shelter manager must log in to continue.");
        return;
    }

    if (!shelter.getShelterManagers().contains(loggedIn)) {
        System.out.println("This manager is not assigned to this shelter.");
        return;
    }

    System.out.println("\nWelcome, " + loggedIn.getFirstName());

    Location location = shelter.getLocation();

    System.out.println("Shelter: " + shelter.getShelterName());
    System.out.println("Location: " + location.getStreet() + ", " + location.getCity() + ", " + location.getState() + " " + location.getZipCode());
    System.out.println("Total capacity: " + shelter.getCapacity());
    System.out.println("Current occupancy: " + shelter.getOccupancy());
    System.out.println("Available spaces: " + (shelter.getCapacity() - shelter.getOccupancy()));

    if (request.getStatus() != Status.IN_PROGRESS) {
        System.out.println("The request must be assigned before check-in.");
        return;
    }

    int people = 0;
    int pets = 0;

    for (Victim victim : request.getVictims()) {
        if (victim instanceof Pet) {
            pets++;
        } else {
            people++;
        }
    }

    int available = shelter.getCapacity() - shelter.getOccupancy();

    if (people == 0 || people > available) {
        System.out.println("No family members listed or insufficient space.");
        return;
    }

    if (pets > 0 && !shelter.getFilters().contains(Filter.PET_FRIENDLY)) {
        System.out.println("This shelter does not accept accompanying pets.");
        return;
    }

    shelter.setCurrentOccupancy(shelter.getOccupancy() + people);

    System.out.println("\nFamily checked in:");

    for (Victim victim : request.getVictims()) {
        if (victim instanceof Pet) {
            Pet pet = (Pet) victim;
            System.out.println("Accompanying pet: " + pet.getFirstName() + " (" + pet.getSpecies() + ")");
        } else {
            System.out.println(victim.getFirstName() + ", age " + victim.getAge());
        }
    }

    System.out.println("Updated human occupancy: " + shelter.getOccupancy());
    System.out.println("Available spaces: "
            + (shelter.getCapacity() - shelter.getOccupancy()));

    completeScenarioRequest(shelter, request);
}

}
