package com.evil.pattern.strategy;

public class BaiduPay implements IPayment{

    @Override
    public void pay(double amount) {
        System.out.println("百度钱包支付成功，金额:"+amount);
    }
}
