package com.evil.pattern.strategy;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.StringBufferInputStream;

public class App {
    public static void main(String[] args) {
//        PayType.WECHAT.getPayment().pay(20d);
//        PayType.ALI.getPayment().pay(30d);
//        PayType.BAIDU.getPayment().pay(50d);

        IPayment payment=new Payment(new WeChatPay());
        payment.pay(50);


    }
}
