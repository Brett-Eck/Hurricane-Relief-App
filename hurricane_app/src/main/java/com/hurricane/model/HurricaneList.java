package com.hurricane.model;

import java.util.ArrayList;
import java.util.UUID;

public class HurricaneList {
    private static final HurricaneList hurricaneList = new HurricaneList();
    private ArrayList<Hurricane> hurricanes = new ArrayList<>();
    DataLoader dataLoader = new DataLoader();
    DataWriter dataWriter = new DataWriter();

    public HurricaneList() {
        hurricanes = dataLoader.getHurricanes();
    }

    public void addHurricane(String hurricaneName, Location location, int category, double windSpeed, double diameter) {
        hurricanes.add(new Hurricane(hurricaneName, location, category, windSpeed, diameter));
    }

    public static HurricaneList getInstance() {
        return hurricaneList;
    }

    public void updateHurricane(UUID id, Location newLocation, int newCategory, double newWindSpeed, double newDiameter) {
        for (Hurricane hurricane : hurricanes) {
            if (hurricane.getId().equals(id)) {
                hurricane.setLocation(newLocation);
                hurricane.setCategory(newCategory);
                hurricane.setWindSpeed(newWindSpeed);
                hurricane.setDiameter(newDiameter);
                return;
            }
        }
    }

    public Hurricane getHurricane(Location location) {
    if (location == null) {
        return null;
    }

    for (Hurricane hurricane : hurricanes) {
        Location hurricaneLocation = hurricane.getLocation();

        if (hurricaneLocation != null
                && hurricaneLocation.getZipCode() == location.getZipCode()) {
            return hurricane;
        }
    }

    return null;
}

    public ArrayList<Hurricane> getHurricanes() {
        return new ArrayList<>(hurricanes);
    }

    public void removeHurricane(UUID id) {
        hurricanes.removeIf(hurricane -> hurricane.getId().equals(id));
    }

    public boolean saveHurricanes() {
        dataWriter.saveHurricanes(hurricanes);
        return true;
    }
}