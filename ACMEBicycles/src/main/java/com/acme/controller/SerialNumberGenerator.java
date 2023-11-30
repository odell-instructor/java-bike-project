package com.acme.controller;

/* Using the Singleton Pattern */
public class SerialNumberGenerator {
    private static SerialNumberGenerator generate;
    private String prefix;
    private int startValue;

    public static synchronized SerialNumberGenerator
        getInstance() {
        if(generate == null) {
            generate = new SerialNumberGenerator();
        }
        return generate;
    }
    private SerialNumberGenerator() {}

    public synchronized void startGeneration(String model,
                                             int startNumber) {
        prefix = model;
        startValue = startNumber;
    }

    public synchronized String getNextSerial() {
        return prefix + (++startValue);
    }

    public synchronized int getRecentNumber() {
        return startValue;
    }

}
