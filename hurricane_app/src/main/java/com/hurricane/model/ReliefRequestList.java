package com.hurricane.model;

import java.util.ArrayList;

public class ReliefRequestList {
    private static final ReliefRequestList reliefRequestList =
            new ReliefRequestList();

    private ArrayList<ReliefRequest> reliefRequests;

    public ReliefRequestList() {
        reliefRequests = new ArrayList<>();
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

    public ArrayList<ReliefRequest> getReliefRequest() {
        return new ArrayList<>(reliefRequests);
    }
}