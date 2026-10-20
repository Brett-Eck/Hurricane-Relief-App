package com.hurricane.model;

public class Location {
    private String street;
    private String city;
    private String state;
    private int zipCode;

    public Location(String street, String city, String state, int zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
