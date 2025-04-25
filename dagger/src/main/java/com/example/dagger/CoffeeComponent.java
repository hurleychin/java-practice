package com.example.dagger;

import dagger.Component;
import javax.inject.Singleton;

/**
 * @author qinhu
 * @date 2025/4/24 18:39
 */

@Singleton // Component must have the same scope as its scoped bindings
@Component(modules = CoffeeModule.class)
public interface CoffeeComponent {
    CoffeeMaker getCoffeeMaker();
}
