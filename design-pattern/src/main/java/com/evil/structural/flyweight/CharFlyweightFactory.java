package com.evil.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * CharFlyweightFactory
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 享元工厂，负责创建和管理享元对象
class CharFlyweightFactory {
    private Map<Character, CharFlyweight> flyweights = new HashMap<>();

    public CharFlyweight getCharFlyweight(char symbol) {
        if (!flyweights.containsKey(symbol)) {
            flyweights.put(symbol, new CharConcreteFlyweight(symbol));
        }
        return flyweights.get(symbol);
    }
}
