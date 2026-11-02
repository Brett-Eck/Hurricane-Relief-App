package com.hurricane.model;
/**
 * Location class matching structure for API
 */
public class Location {
    private String street;
    private String city;
    private String state;
    private int zipCode;
/**
 * 
 * @param street
 * @param city
 * @param state
 * @param zipCode
 */
    public Location(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    /**
     * Gets the ZIP code of the location.
     *
     * @return the ZIP code
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     * Gets the street address.
     *
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Gets the city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }
}
