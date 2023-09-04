package com.evil.behavioral.mediator;

/**
 * AirTrafficControl
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 中介者接口
interface AirTrafficControl {
    void requestToLand(Aircraft aircraft);

    void requestTakeoff(Aircraft aircraft);
}
