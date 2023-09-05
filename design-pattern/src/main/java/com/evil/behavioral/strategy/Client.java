package com.evil.behavioral.strategy;

public class Client {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // 选择信用卡支付策略
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);

        // 切换为PayPal支付策略
        cart.setPaymentStrategy(new PayPalPayment("john@example.com"));
        cart.checkout(50);
    }
}
