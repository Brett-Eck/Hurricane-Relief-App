package com.hurricane.model;


public class Victim {
    private String firstName;
    private String lastName;
    private String description;
    private String gender;
    private int age;
    private VICTIM_STATUS victimStatus;

    public Victim(String firstName, VICTIM_STATUS victimStatus) {
        this.firstName = firstName;
        this.victimStatus = victimStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public VICTIM_STATUS getVictimStatus() {
        return victimStatus;
    }

    public void setVictimStatus(VICTIM_STATUS status) {
        victimStatus = status;
    }
}
