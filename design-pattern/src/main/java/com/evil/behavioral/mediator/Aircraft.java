package com.evil.behavioral.mediator;

/**
 * Aircraft
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 抽象同事类：飞机
abstract class Aircraft {
    protected AirTrafficControl atc;
    private String name;

    public Aircraft(AirTrafficControl atc, String name) {
        this.atc = atc;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void land();

    public abstract void takeoff();
}
