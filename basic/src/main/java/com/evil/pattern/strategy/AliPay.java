package com.evil.pattern.strategy;

public class AliPay implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("支付宝支付成功，金额:"+amount);
    }
}
