package com.evil.behavioral.mediator;

/**
 * CargoPlane
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体同事类：货机
class CargoPlane extends Aircraft {
    public CargoPlane(AirTrafficControl atc, String name) {
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
