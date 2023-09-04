package com.evil.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * AirTrafficControlCenter
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体中介者：飞机调度中心
class AirTrafficControlCenter implements AirTrafficControl {
    private List<Aircraft> aircrafts = new ArrayList<>();

    @Override
    public void requestToLand(Aircraft aircraft) {
        if (isRunwayClear()) {
            System.out.println(aircraft.getName() + " 请求降落。");
            aircrafts.add(aircraft);
        } else {
            System.out.println("跑道已被占用，" + aircraft.getName() + " 无法降落。");
        }
    }

    @Override
    public void requestTakeoff(Aircraft aircraft) {
        System.out.println(aircraft.getName() + " 请求起飞。");
        aircrafts.remove(aircraft);
    }

    private boolean isRunwayClear() {
        return aircrafts.isEmpty();
    }
}
