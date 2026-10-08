package com.hurricane.model;
/**
 * @author Nyesh1
 * Pet class representing a pet in the hurricane relief application
 */

public class Pet extends Victim {
    private String species;

    public Pet(Victim_Status victimStatus, String species) {
        super(null, victimStatus);
        this.species = species;
    }
}
