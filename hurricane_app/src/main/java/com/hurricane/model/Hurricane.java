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

    /**
     * Creates a hurricane with its name, location, and storm details.
     *
     * @param hurricaneName the name of the hurricane
     * @param location the hurricane's location
     * @param category the hurricane category
     * @param windSpeed the wind speed
     * @param diameter the hurricane diameter
     */
    public Hurricane(String hurricaneName, Location location, int category,
                     double windSpeed, double diameter) {
        this.hurricaneName = hurricaneName;
        this.location = location;
        this.category = category;
        this.windSpeed = windSpeed;
        this.diameter = diameter;
        this.id = UUID.randomUUID();
    }

    /**
     * Updates the hurricane's location.
     *
     * @param location the new location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * Updates the hurricane's name.
     *
     * @param hurricaneName the new name
     */
    public void setHurricaneName(String hurricaneName) {
        this.hurricaneName = hurricaneName;
    }

    /**
     * Gets the hurricane's name.
     *
     * @return the hurricane name
     */
    public String getName() {
        return hurricaneName;
    }

    /**
     * Updates the hurricane category.
     *
     * @param category the new category
     */
    public void setCategory(int category) {
        this.category = category;
    }

    /**
     * Updates the hurricane's wind speed.
     *
     * @param windSpeed the new wind speed
     */
    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    /**
     * Updates the hurricane's diameter.
     *
     * @param diameter the new diameter
     */
    public void setDiameter(double diameter) {
        this.diameter = diameter;
    }

    /**
     * Gets the hurricane's name.
     *
     * @return the hurricane name
     */
    public String getHurricaneName() {
        return hurricaneName;
    }

    /**
     * Gets the hurricane's location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Gets the hurricane category.
     *
     * @return the category
     */
    public int getCategory() {
        return category;
    }

    /**
     * Gets the hurricane's wind speed.
     *
     * @return the wind speed
     */
    public double getWindSpeed() {
        return windSpeed;
    }

    /**
     * Gets the hurricane's diameter.
     *
     * @return the diameter
     */
    public double getDiameter() {
        return diameter;
    }

    /**
     * Gets the hurricane's unique ID.
     *
     * @return the hurricane ID
     */
    public UUID getId() {
        return id;
    }
}