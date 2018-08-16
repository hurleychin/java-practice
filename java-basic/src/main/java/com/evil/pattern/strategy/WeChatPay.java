package com.evil.pattern.strategy;

public class WeChatPay implements IPayment {
    @Override
    public void pay(double amount) {
        System.out.println("微信支付成功，金额:"+amount);
    }
}
