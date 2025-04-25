package com.example.dagger;

import javax.inject.Singleton;

/**
 * @author qinhu
 * @date 2025/4/24 18:36
 */
public class ElectricHeater implements Heater {
    private static int instanceCounter = 0;
    private final int instanceNumber;

    public ElectricHeater() {
        instanceCounter++;
        instanceNumber = instanceCounter;
        System.out.println("Creating ElectricHeater instance #" + instanceNumber);
    }

    @Override
    public void heater() {
        System.out.println("ElectricHeater #" + instanceNumber + " heating...");
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
