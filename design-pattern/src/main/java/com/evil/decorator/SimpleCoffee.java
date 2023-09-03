package com.evil.decorator;

public class SimpleCoffee implements Coffee {
    @Override
    public double getCost() {
        return 5.0; // 基本咖啡价格
    }

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
}
