package com.evil.behavioral.strategy;

/**
 * PayPalPayment
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体策略2：PayPal支付
class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("使用PayPal支付 $" + amount + "，邮箱：" + email);
    }
}
