package com.hurricane.model;


public class Victim {
    private String firstName;
    private String lastName;
    private String description;
    private String gender;
    private int age;
    private VictimStatus victimStatus;

    public Victim(String firstName, VictimStatus victimStatus, int age) {
        this.firstName = firstName;
        this.victimStatus = victimStatus;
        this.age = age;
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

    public VictimStatus getVictimStatus() {
        return victimStatus;
    }

    public void setVictimStatus(VictimStatus status) {
        victimStatus = status;
    }
}
