package com.evil.pattern.strategy;

public enum PayType {
    WECHAT(new WeChatPay()),ALI(new AliPay()),BAIDU(new BaiduPay());
    private IPayment payment;
    PayType(IPayment payment){
       this.payment=payment;
    }
    public IPayment getPayment() {
        return payment;
    }
}
