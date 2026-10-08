package com.hurricane.model;

import java.util.UUID;

/**
 * Represents a hurricane in the relief system.
 * Stores the hurricane's location, category, wind speed, diameter, and unique ID.
 */

public class Hurricane {

    
    private String hurricaneName;
    private Location location;
    private int category;
    private double windSpeed;
    private double diameter;
    private UUID id;

    public Hurricane(String hurricaneName, Location location, int category,
                     double windSpeed, double diameter) {
        this.hurricaneName = hurricaneName;
        this.location = location;
        this.category = category;
        this.windSpeed = windSpeed;
        this.diameter = diameter;
        this.id = UUID.randomUUID();
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    public String getHurricaneName() {
        return hurricaneName;
    }

    public Location getLocation() {
        return location;
    }

    public int getCategory() {
        return category;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getDiameter() {
        return diameter;
    }

    public UUID getId() {
        return id;
    }
}