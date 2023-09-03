package com.evil.decorator;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 2.0; // 牛奶价格
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Milk";
    }
}

