package com.hurricane.model;

/**
 * Holds constants used for handling application data.
 */
public class DataConstants {
    
    public static boolean isJUnitTest() {
        for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
            if (element.getClassName().startsWith("org.junit.")) {
                return true;
            }
        }
        return false;
    }
}
