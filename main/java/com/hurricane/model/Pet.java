package com.hurricane.model;
/**
 * @author Nyesh1
 * Pet class representing a pet in the hurricane relief application
 */

public class Pet extends Victim {
    private String species;

    public Pet(String name, VictimStatus victimStatus, String species, int age) {
        super(name, victimStatus, age);
        this.species = species;
    }

    public String getSpecies() {
        return species;
    }
}
