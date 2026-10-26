package com.hurricane.model;


/**
 * Represents a victim in the hurricane relief system.
 * Stores their personal information and current condition.
 */
public class Victim {
    private String firstName;
    private String lastName;
    private String description;
    private String gender;
    private int age;
    private VictimStatus victimStatus;

    /**
     * Creates a victim with their name, status, and age.
     *
     * @param firstName the victim's first name
     * @param victimStatus the victim's current condition
     * @param age the victim's age
     */
    public Victim(String firstName, VictimStatus victimStatus, int age) {
        this.firstName = firstName;
        this.victimStatus = victimStatus;
        this.age = age;
    }

    /**
     * Gets the victim's first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Gets the victim's last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Gets the victim's description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the victim's gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Gets the victim's age.
     *
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the victim's current status.
     *
     * @return the victim status
     */
    public VictimStatus getVictimStatus() {
        return victimStatus;
    }

    /**
     * Updates the victim's status.
     *
     * @param status the new victim status
     */
    public void setVictimStatus(VictimStatus status) {
        victimStatus = status;
    }
}
