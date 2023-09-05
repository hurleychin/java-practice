package com.evil.behavioral.strategy;

/**
 * PaymentStrategy
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 策略接口
interface PaymentStrategy {
    void pay(int amount);
}
