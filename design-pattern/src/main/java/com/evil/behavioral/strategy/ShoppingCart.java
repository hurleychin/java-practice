package com.evil.behavioral.strategy;

/**
 * ShoppingCart
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 上下文类，用于选择和执行支付策略
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        paymentStrategy.pay(amount);
    }
}
