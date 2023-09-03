package com.evil.decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: " + coffee.getCost() + " USD"); // 输出：Cost: 5.0 USD

        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Cost: " + milkCoffee.getCost() + " USD"); // 输出：Cost: 7.0 USD

        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.getCost() + " USD"); // 输出：Cost: 8.0 USD
        System.out.println("Description: " + sugarMilkCoffee.getDescription()); // 输出：Description: Simple Coffee, Milk, Sugar
    }
}
