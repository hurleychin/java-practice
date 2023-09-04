package com.evil.structural.decorator;

/**
 * SugarDecorator
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() {
        return super.getCost() + 1.0; // 糖的价格
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Sugar";
    }
}
