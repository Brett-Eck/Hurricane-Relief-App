package com.hurricane.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class DataWriter {
    public boolean saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for(int i = 0; i < userList.size(); ++i) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter("../json/users.json")) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveShelters(ArrayList<Shelter> shelters) {
        ShelterList shelterList = ShelterList.getInstance();
        ArrayList<Shelter> shelterListItems = shelterList.getShelters();
        JSONArray jsonShelters = new JSONArray();

        for(int i = 0; i < shelterListItems.size(); ++i) {
            jsonShelters.add(getShelterJSON(shelterListItems.get(i)));
        }

        try (FileWriter file = new FileWriter("../json/shelters.json")) {
            file.write(jsonShelters.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveReliefRequests(ArrayList<ReliefRequest> reliefRequests) {
        ReliefRequestList reliefRequestList = ReliefRequestList.getInstance();
        ArrayList<ReliefRequest> reliefRequestListItems = reliefRequestList.getReliefRequests();
        JSONArray jsonReliefRequests = new JSONArray();

        for(int i = 0; i < reliefRequestListItems.size(); ++i) {
            jsonReliefRequests.add(getReliefRequestJSON(reliefRequestListItems.get(i)));
        }

        try (FileWriter file = new FileWriter("../json/reliefRequests.json")) {
            file.write(jsonReliefRequests.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveHurricanes(ArrayList<Hurricane> hurricanes) {
        HurricaneList hurricaneList = HurricaneList.getInstance();
        ArrayList<Hurricane> hurricaneListItems = hurricaneList.getHurricanes();
        JSONArray jsonHurricanes = new JSONArray();

        for(int i = 0; i < hurricaneListItems.size(); ++i) {
            jsonHurricanes.add(getHurricaneJSON(hurricaneListItems.get(i)));
        }

        try (FileWriter file = new FileWriter("../json/hurricanes.json")) {
            file.write(jsonHurricanes.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
        jsonReliefRequest.put("requesterName", reliefRequest.getRequesterName());
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
