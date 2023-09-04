package com.evil.behavioral.mediator;

public class Client {
    public static void main(String[] args) {
        // 创建飞机调度中心
        AirTrafficControl atc = new AirTrafficControlCenter();

        // 创建客机和货机
        Aircraft passengerPlane = new PassengerPlane(atc, "客机001");
        Aircraft cargoPlane = new CargoPlane(atc, "货机101");

        // 请求起飞和降落
        passengerPlane.takeoff();
        cargoPlane.land();
        passengerPlane.land();
    }
}
