package com.hurricane.model;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class DataWriter {
    public static void main(String[] args) {
        DataWriter dataWriter = new DataWriter();
        dataWriter.saveUsers();
        dataWriter.saveShelters(ShelterList.getInstance().getShelters());
        dataWriter.saveReliefRequests(ReliefRequestList.getInstance().getReliefRequests());
        dataWriter.saveHurricanes(HurricaneList.getInstance().getHurricanes());
    }

    public boolean saveUsers() {
        try {
            var path = Paths.get("hurricane_app/json/users.json");
            JSONArray jsonUsers = new JSONArray();

            if (Files.exists(path) && Files.size(path) > 0) {
                jsonUsers = (JSONArray) new JSONParser().parse(Files.readString(path));
            }

            for (User user : UserList.getInstance().getUsers()) {
                jsonUsers.add(getUserJSON(user));
            }

            try (FileWriter file = new FileWriter(path.toFile())) {
                file.write(jsonUsers.toJSONString());
            }
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveShelters(ArrayList<Shelter> shelters) {
        try {
            var path = Paths.get("hurricane_app/json/shelters.json");
            JSONArray jsonShelters = new JSONArray();

            if (Files.exists(path) && Files.size(path) > 0) {
                jsonShelters = (JSONArray) new JSONParser().parse(Files.readString(path));
            }

            for (Shelter shelter : shelters) {
                jsonShelters.add(getShelterJSON(shelter));
            }

            try (FileWriter file = new FileWriter(path.toFile())) {
                file.write(jsonShelters.toJSONString());
            }
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveReliefRequests(ArrayList<ReliefRequest> reliefRequests) {
        try {
            var path = Paths.get("hurricane_app/json/reliefRequests.json");
            JSONArray jsonReliefRequests = new JSONArray();

            if (Files.exists(path) && Files.size(path) > 0) {
                jsonReliefRequests = (JSONArray) new JSONParser().parse(Files.readString(path));
            }

            for (ReliefRequest reliefRequest : reliefRequests) {
                jsonReliefRequests.add(getReliefRequestJSON(reliefRequest));
            }

            try (FileWriter file = new FileWriter(path.toFile())) {
                file.write(jsonReliefRequests.toJSONString());
            }
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean saveHurricanes(ArrayList<Hurricane> hurricanes) {
        try {
            var path = Paths.get("hurricane_app/json/hurricanes.json");
            JSONArray jsonHurricanes = new JSONArray();

            if (Files.exists(path) && Files.size(path) > 0) {
                jsonHurricanes = (JSONArray) new JSONParser().parse(Files.readString(path));
            }

            for (Hurricane hurricane : hurricanes) {
                jsonHurricanes.add(getHurricaneJSON(hurricane));
            }

            try (FileWriter file = new FileWriter(path.toFile())) {
                file.write(jsonHurricanes.toJSONString());
            }
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static JSONObject getShelterJSON(Shelter shelter) {
        JSONObject jsonShelter = new JSONObject();
        jsonShelter.put("id", shelter.getId().toString());
        jsonShelter.put("name", shelter.getShelterName());
        jsonShelter.put("zipCode", shelter.getLocation().getZipCode());
        jsonShelter.put("capacity", shelter.getCapacity());
        return jsonShelter;
    }

    public static JSONObject getReliefRequestJSON(ReliefRequest reliefRequest) {
        JSONObject jsonReliefRequest = new JSONObject();
        jsonReliefRequest.put("id", reliefRequest.getId().toString());
        jsonReliefRequest.put("phoneNumber", reliefRequest.getPhoneNumber());
        jsonReliefRequest.put("location", reliefRequest.getLocation().toString());
        jsonReliefRequest.put("status", reliefRequest.getStatus().toString());
        return jsonReliefRequest;
    }

    public static JSONObject getHurricaneJSON(Hurricane hurricane) {
        JSONObject jsonHurricane = new JSONObject();
        jsonHurricane.put("id", hurricane.getId().toString());
        jsonHurricane.put("name", hurricane.getName());
        jsonHurricane.put("category", hurricane.getCategory());
        jsonHurricane.put("location", hurricane.getLocation().toString());
        return jsonHurricane;
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject jsonUser = new JSONObject();
        jsonUser.put("id", user.getId().toString());
        jsonUser.put("firstName", user.getFirstName());
        jsonUser.put("lastName", user.getLastName());
        jsonUser.put("birthDate", user.getBirthDate().toString());
        jsonUser.put("email", user.getEmail());
        jsonUser.put("password", user.getPassword());
        jsonUser.put("userName", user.getUsername());
        return jsonUser;
    }
}
