package com.example.dagger;

import javax.inject.Inject;

/**
 * @author qinhu
 * @date 2025/4/24 18:41
 */

public class CoffeeMaker {
   private final Heater heater;
   private final Pump pump;

   @Inject
   public CoffeeMaker(Heater heater, Pump pump) {
       this.heater = heater;
       this.pump = pump;
   }

    public void brew(){
        heater.heater();
        pump.pump();
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // Create a single component instance
        CoffeeComponent coffeeComponent = DaggerCoffeeComponent.create();

        // Get multiple CoffeeMaker instances from the same component
        System.out.println("\nCreating first CoffeeMaker instance:");
        CoffeeMaker coffeeMaker1 = coffeeComponent.getCoffeeMaker();
        coffeeMaker1.brew();

        System.out.println("\nCreating second CoffeeMaker instance:");
        CoffeeMaker coffeeMaker2 = coffeeComponent.getCoffeeMaker();
        coffeeMaker2.brew();

        // Create a new component to demonstrate that a new singleton instance will be created
        System.out.println("\nCreating a new component:");
        CoffeeComponent anotherComponent = DaggerCoffeeComponent.create();
        CoffeeMaker coffeeMaker3 = anotherComponent.getCoffeeMaker();
        coffeeMaker3.brew();

        System.out.println("\nDemonstration of @Singleton scope:");
        System.out.println("- When using the same component, the same Heater instance is reused");
        System.out.println("- When creating a new component, a new Heater instance is created");
    }
}
