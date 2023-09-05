package com.evil.behavioral.strategy;

/**
 * CreditCardPayment
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体策略1：信用卡支付
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println("使用信用卡支付 $" + amount + "，卡号：" + cardNumber + "，持卡人：" + name);
    }
}
