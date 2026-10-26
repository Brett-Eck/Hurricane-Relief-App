package com.hurricane.model;

import java.util.ArrayList;

/**
 * Manages relief requests in the system, including searching,
 * adding requests, and saving them.
 */
public class ReliefRequestList {
    private static final ReliefRequestList reliefRequestList =
            new ReliefRequestList();

    private ArrayList<ReliefRequest> reliefRequests;
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();

    /**
     * Creates the relief request list and loads existing requests.
     */
    public ReliefRequestList() {
        reliefRequests = dataLoader.getReliefRequests();
    }

    /**
     * Gets the single instance of ReliefRequestList.
     *
     * @return the ReliefRequestList instance
     */
    public static ReliefRequestList getInstance() {
        return reliefRequestList;
    }

    /**
     * Adds a relief request to the list.
     *
     * @param reliefRequest the request to add
     */
    public void addReliefRequest(ReliefRequest reliefRequest) {
        reliefRequests.add(reliefRequest);
    }

    /**
     * Gets all relief requests in the system.
     *
     * @return a copy of the relief request list
     */
    public ArrayList<ReliefRequest> getReliefRequests() {
        return new ArrayList<>(reliefRequests);
    }

    /**
     * Finds a relief request using its contact phone number.
     *
     * @param phoneNumber the phone number to search for
     * @return the matching request, or null if not found
     */
    public ReliefRequest getReliefRequest(String phoneNumber) {
        for (ReliefRequest request : reliefRequests) {
            if (request.getPhoneNumber() != null && request.getPhoneNumber().equals(phoneNumber)) {
                return request;
            }
        }
        return null;
    }

    /**
     * Finds a relief request using its ID.
     *
     * @param id the request ID to search for
     * @return the matching request, or null if not found
     */
    public ReliefRequest getActiveReliefRequestById(String id) {
        for (ReliefRequest reliefRequest : reliefRequests) {
            if (reliefRequest.getId().toString().equals(id)) {
                return reliefRequest;
            }
        }
        return null;
    }

    /**
     * Finds the nearest relief request using the demo ZIP code distances.
     * Only searches when the starting ZIP code is 29210.
     *
     * @param location the location to search from
     * @return the nearest request, or null if none is found
     */
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

    /**
     * Saves the current relief requests.
     *
     * @return true after saving the requests
     */
    public boolean saveReliefRequests() {
        dataWriter.saveReliefRequests(reliefRequests);
        return true;
    }
}