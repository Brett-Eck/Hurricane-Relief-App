package com.hurricane.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader {
     public static void main(String[] args) {
        JSONParser jsonPaser = new JSONParser();
        
        try {
            File jsonFile = new File("../json/users.json");
            ArrayList<User> users = jsonPaser.parse(new FileReader(jsonFile));
            
            for (User user : users) {
                System.out.println(user.getName());
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        
        return reliefRequests;
    }
