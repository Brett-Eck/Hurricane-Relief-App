package com.hurricane.model;
import java.util.UUID;

public class RandomIDGenerator {
    public static void main(String[] args) {
        String randomID = UUID.randomUUID().toString();

        System.out.println(randomID);
    }
}
