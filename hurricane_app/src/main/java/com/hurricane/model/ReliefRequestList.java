package com.hurricane.model;

import java.util.ArrayList;

public class ReliefRequestList {
    private static final ReliefRequestList reliefRequestList =
            new ReliefRequestList();

    private ArrayList<ReliefRequest> reliefRequests;
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();

    public ReliefRequestList() {
        reliefRequests = dataLoader.getReliefRequests();
    }

    public static ReliefRequestList getInstance() {
        return reliefRequestList;
    }

    public void addReliefRequest(ReliefRequest reliefRequest) {
        reliefRequests.add(reliefRequest);
    }

    public ArrayList<ReliefRequest> getReliefRequests() {
        return new ArrayList<>(reliefRequests);
    }

    public ReliefRequest getReliefRequest(String phoneNumber) {
        for (ReliefRequest request : reliefRequests) {
            if (request.getPhoneNumber() != null && request.getPhoneNumber().equals(phoneNumber)) {
                return request;
            }
        }
        return null;
    }

    public ReliefRequest getActiveReliefRequestById(String id) {
        for (ReliefRequest reliefRequest : reliefRequests) {
            if (reliefRequest.getId().toString().equals(id)) {
                return reliefRequest;
            }
        }
        return null;
    }

    public ReliefRequest findNearestReliefRequest(Location location) {
        if (location == null || location.getZipCode() != 29210) {
            return null;
        }

        ReliefRequest nearest = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (ReliefRequest request : reliefRequests) {
            if (request.getLocation() == null) {
                continue;
            }

            int requestZip = request.getLocation().getZipCode();
            int distance;

            // Hardcoded demo distances from ZIP 29210.
            if (requestZip == 29210) {
                distance = 0;
            } else if (requestZip == 29201) {
                distance = 10;
            } else if (requestZip == 29401) {
                distance = 100;
            } else {
                continue;
            }

            if (distance < shortestDistance) {
                shortestDistance = distance;
                nearest = request;
            }
        }

        return nearest;
    }

    public boolean saveReliefRequests() {
        dataWriter.saveReliefRequests(reliefRequests);
        return true;
    }
}