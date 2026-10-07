package com.hurricane.model;

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
        
        try {
            FileReader reader = new FileReader("../json/users.json");
            JSONArray peopleJSON = (JSONArray)(new JSONParser()).parse(reader);

            for(int i = 0; i < peopleJSON.size(); ++i) {
                JSONObject personJSON = (JSONObject)peopleJSON.get(i);
                UUID id = UUID.fromString((String)personJSON.get("id"));
                LocalDate birthDate = LocalDate.parse((String)personJSON.get("birthDate"));
                String email = (String)personJSON.get("email");
                String password = (String)personJSON.get("password");
                String userName = (String)personJSON.get("userName");
                String firstName = (String)personJSON.get("firstName");
                String lastName = (String)personJSON.get("lastName");
                users.add(new User(firstName, lastName, birthDate, email, password, userName));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }


    public ArrayList<Shelter> getShelters() {
        ArrayList<Shelter> shelters = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader("../json/shelters.json");
            JSONArray sheltersJSON = (JSONArray)(new JSONParser()).parse(reader);

            for(int i = 0; i < sheltersJSON.size(); ++i) {
                JSONObject shelterJSON = (JSONObject)sheltersJSON.get(i);
                UUID id = UUID.fromString((String)shelterJSON.get("id"));
                String name = (String)shelterJSON.get("name");
                int zipCode = ((Long)shelterJSON.get("zipCode")).intValue();
                int capacity = ((Long)shelterJSON.get("capacity")).intValue();
                shelters.add(new Shelter(name, capacity, new Location(zipCode)));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shelters;
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        ArrayList<ReliefRequest> reliefRequests = new ArrayList<>();
        
        try {
            FileReader reader = new FileReader("../json/reliefRequests.json");
            JSONArray requestsJSON = (JSONArray)(new JSONParser()).parse(reader);

            for(int i = 0; i < requestsJSON.size(); ++i) {
                JSONObject requestJSON = (JSONObject)requestsJSON.get(i);
                UUID id = UUID.fromString((String)requestJSON.get("id"));
                ArrayList<Victim> victims = ((JSONArray)requestJSON.get("victims"));
                ArrayList<HAZARD> hazards = ((JSONArray)requestJSON.get("hazards"));
                String photo = (String)requestJSON.get("photo") != null ? (String)requestJSON.get("photo") : null;
                ArrayList<ASSISTANCE_TYPE> assistanceTypes = ((JSONArray)requestJSON.get("assistanceTypes"));
                STATUS status = (STATUS)requestJSON.get("status");
                String description = (String)requestJSON.get("description");
                String phoneNumber = (String)requestJSON.get("phoneNumber");
                int zipCode = ((Long)requestJSON.get("zipCode")).intValue();
                

                reliefRequests.add(new ReliefRequest(victims, hazards, photo, assistanceTypes, status, description, phoneNumber, id, new Location(zipCode)));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reliefRequests;
    }

    public ArrayList<Hurricane> getHurricanes() {
    ArrayList<Hurricane> hurricanes = new ArrayList<>();

    try {
        FileReader reader = new FileReader("../json/hurricanes.json");

        JSONObject root = (JSONObject)(new JSONParser()).parse(reader);
        JSONArray hurricanesJSON = (JSONArray)root.get("hurricanes");

        for(int i = 0; i < hurricanesJSON.size(); ++i) {
            JSONObject hurricaneJSON = (JSONObject)hurricanesJSON.get(i);
            String hurricaneName = (String)hurricaneJSON.get("hurricaneName");
            JSONObject locationJSON = (JSONObject)hurricaneJSON.get("location");
            int zipCode = ((Long)locationJSON.get("zipCode")).intValue();
            Location location = new Location(zipCode);
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
