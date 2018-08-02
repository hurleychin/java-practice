package com.evil.pattern.strategy;

public class Payment implements IPayment {
    private IPayment payment;
    public Payment(IPayment payment){
       this.payment=payment;
    }
    @Override
    public void pay(double amount) {
       payment.pay(amount);
    }
}
