package com.example.dagger;

/**
 * @author qinhu
 * @date 2025/4/24 18:37
 */
public class ThermosiphonPump implements Pump {


    private static int instanceCounter = 0;
    private final int instanceNumber;

    public ThermosiphonPump() {
        instanceCounter++;
        instanceNumber = instanceCounter;
        System.out.println("Creating ThermosiphonPump instance #" + instanceNumber);
    }

    @Override
    public void pump() {
        System.out.println("ThermosiphonPump #" + instanceNumber + " pumping...");
    }
}
