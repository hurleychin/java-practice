package com.example.dagger;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * @author qinhu
 * @date 2025/4/24 18:37
 */

@Module
public class CoffeeModule {
    @Provides
    @Singleton // This annotation ensures only one instance of ElectricHeater is created
    public Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides
    public Pump providePump () {
        return new ThermosiphonPump();
    }
}
