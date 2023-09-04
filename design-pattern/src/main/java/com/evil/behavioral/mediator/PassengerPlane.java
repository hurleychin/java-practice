package com.evil.behavioral.mediator;

/**
 * PassengerPlane
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体同事类：客机
class PassengerPlane extends Aircraft {
    public PassengerPlane(AirTrafficControl atc, String name) {
        super(atc, name);
    }

    @Override
    public void land() {
        atc.requestToLand(this);
    }

    @Override
    public void takeoff() {
        atc.requestTakeoff(this);
    }
}
