package com.hurricane.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

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
                String userName = (String)personJSON.get("userName");
                String firstName = (String)personJSON.get("firstName");
                String lastName = (String)personJSON.get("lastName");
                int age = ((Long)personJSON.get("age")).intValue();
                String phoneNumber = (String)personJSON.get("phoneNumber");
                users.add(new User(id, userName, firstName, lastName, age, phoneNumber));
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
                String address = (String)shelterJSON.get("address");
                String city = (String)shelterJSON.get("city");
                String state = (String)shelterJSON.get("state");
                String zipCode = (String)shelterJSON.get("zipCode");
                shelters.add(new Shelter(id, name, address, city, state, zipCode));
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
                String userName = (String)requestJSON.get("userName");
                String firstName = (String)requestJSON.get("firstName");
                String lastName = (String)requestJSON.get("lastName");
                int age = ((Long)requestJSON.get("age")).intValue();
                String phoneNumber = (String)requestJSON.get("phoneNumber");
                reliefRequests.add(new ReliefRequest(id, userName, firstName, lastName, age, phoneNumber));
            }
 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reliefRequests;
    }
    }
