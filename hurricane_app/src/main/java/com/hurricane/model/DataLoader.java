package com.hurricane.model;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;
import java.time.LocalDate;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants{

    
     
public static ArrayList<User> getUsers() {
    ArrayList<User> users = new ArrayList<>();

    File file = new File("json/users.json");

    if (!file.exists()) {
        file = new File("hurricane_app/json/users.json");
    }

    try (FileReader reader = new FileReader(file)) {
        JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

        for (Object entry : peopleJSON) {
            JSONObject personJSON = (JSONObject) entry;

            String type = (String) personJSON.get("type");
            String firstName = (String) personJSON.get("firstName");
            String lastName = (String) personJSON.get("lastName");
            String email = (String) personJSON.get("email");
            String password = (String) personJSON.get("password");
            String userName = (String) personJSON.get("userName");
            LocalDate birthDate = LocalDate.parse((String) personJSON.get("birthDate"));

            JSONObject locationJSON = (JSONObject) personJSON.get("location");
            Location location;

            if (locationJSON != null) {
                String street = (String) locationJSON.get("street");
                String city = (String) locationJSON.get("city");
                String state = (String) locationJSON.get("state");
                int zipCode = ((Number) locationJSON.get("zipCode")).intValue();

                location = new Location(street, city, state, zipCode);
            } else {
                int zipCode = ((Number) personJSON.get("zipCode")).intValue();
                location = new Location("", "", "", zipCode);
            }

            if ("Volunteer".equals(type)) {
                Volunteer volunteer = new Volunteer(firstName, lastName, birthDate,
                        email, password, userName, location);

                JSONArray vehiclesJSON = (JSONArray) personJSON.get("vehicles");

                if (vehiclesJSON != null) {
                    for (Object vehicle : vehiclesJSON) {
                        volunteer.addVehicle(Vehicle.valueOf((String) vehicle));
                    }
                }

                users.add(volunteer);
            } else {
                users.add(new User(firstName, lastName, birthDate,
                        email, password, userName, location));
            }
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return users;
}


    public ArrayList<Shelter> getShelters() {
        ArrayList<Shelter> shelters = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader("json/shelters.json");
           JSONObject root = (JSONObject) new JSONParser().parse(reader);
            JSONArray sheltersJSON = (JSONArray) root.get("shelters");  

            for(int i = 0; i < sheltersJSON.size(); ++i) {
                JSONObject shelterJSON = (JSONObject)sheltersJSON.get(i);
                UUID id = UUID.fromString((String)shelterJSON.get("id"));
                String name = (String)shelterJSON.get("shelterName");
                JSONObject locationJSON = (JSONObject)shelterJSON.get("location");
                String street = (String)locationJSON.getOrDefault("street", "");
                String city = (String)locationJSON.getOrDefault("city", "");
                String state = (String)locationJSON.getOrDefault("state", "");      
                int zipCode = ((Long)locationJSON.get("zipCode")).intValue();
                int capacity = ((Long)shelterJSON.get("currentCapacity")).intValue();
                shelters.add(new Shelter(name, capacity, new Location(street, city, state, zipCode)));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelters;
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        ArrayList<ReliefRequest> reliefRequests = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader("json/reliefRequests.json");
            JSONObject root = (JSONObject) new JSONParser().parse(reader);
            JSONArray requestsJSON = (JSONArray) root.get("reliefRequests");

            for(int i = 0; i < requestsJSON.size(); ++i) {
                JSONObject requestJSON = (JSONObject)requestsJSON.get(i);
                UUID id = UUID.fromString((String)requestJSON.get("id"));
                String username = (String)requestJSON.get("userName");
                ArrayList<Victim> victims = new ArrayList<>();
                ArrayList<Hazard> hazards = new ArrayList<>();
                JSONArray hazardsJSON = (JSONArray) requestJSON.get("hazards");

                if (hazardsJSON != null) {
                    for (Object value : hazardsJSON) {
                        hazards.add(Hazard.valueOf((String) value));
                    }
                }
                String photo = (String)requestJSON.get("photo") != null ? (String)requestJSON.get("photo") : null;
                
                ArrayList<AssistanceType> assistanceTypes = new ArrayList<>();
                JSONArray typesJSON = (JSONArray) requestJSON.get("assistanceTypeNeeded");

                if (typesJSON != null) {
                    for (Object value : typesJSON) {
                        String type = (String) value;

                        if (type.equals("TRANSPORTATION")) {
                            type = "TRANSPORTAION";
                        }

                        assistanceTypes.add(AssistanceType.valueOf(type));
                    }
                }

                Status status = Status.valueOf((String)requestJSON.get("status"));
                String description = (String)requestJSON.get("description");
                String phoneNumber = (String)requestJSON.get("phoneNumber");
                JSONObject locationJSON = (JSONObject)requestJSON.get("location");
                String street = (String) locationJSON.getOrDefault("street", "");
                String city = (String) locationJSON.getOrDefault("city", "");
                String state = (String) locationJSON.getOrDefault("state", "");
                int zipCode = ((Long)locationJSON.get("zipCode")).intValue();
                

                reliefRequests.add(new ReliefRequest(username, victims, hazards, photo, assistanceTypes, status, description, phoneNumber, id, new Location(street, city, state, zipCode)));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reliefRequests;
    }

    public ArrayList<Hurricane> getHurricanes() {
    ArrayList<Hurricane> hurricanes = new ArrayList<>();

    try {
        FileReader reader = new FileReader("json/hurricanes.json");

        JSONObject root = (JSONObject)(new JSONParser()).parse(reader);
        JSONArray hurricanesJSON = (JSONArray)root.get("hurricanes");

        for(int i = 0; i < hurricanesJSON.size(); ++i) {
            JSONObject hurricaneJSON = (JSONObject)hurricanesJSON.get(i);
            String hurricaneName = (String)hurricaneJSON.get("hurricaneName");
            JSONObject locationJSON = (JSONObject)hurricaneJSON.get("location");
            String street = (String)locationJSON.get("street");
            String city = (String)locationJSON.get("city");
            String state = (String)locationJSON.get("state");
            int zipCode = ((Long)locationJSON.get("zipCode")).intValue();
            Location location = new Location(street, city, state, zipCode);
            int category = ((Long)hurricaneJSON.get("category")).intValue();
            double windSpeed = ((Number)hurricaneJSON.get("windSpeed")).doubleValue();
            double diameter = ((Number)hurricaneJSON.get("diameter")).doubleValue();
            UUID id = UUID.fromString((String)hurricaneJSON.get("id"));

            hurricanes.add(new Hurricane(hurricaneName, location, category, windSpeed, diameter));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return hurricanes;
}
    
}

