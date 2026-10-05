package com.hurricane.model;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.util.ArrayList;

public class DataLoader {
    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Shelter> getShelters() {
        return shelters;
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        
        return reliefRequests;
    }
}
