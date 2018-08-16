package com.evil.generics.pecs;

import java.util.Collection;

class Shoe {}
class IPhone {}
interface Fruit {}
class Apple implements Fruit {}
class Banana implements Fruit {}
class GrannySmith extends Apple {}

/**
 *  有界泛型
 */
public class FruitHelper {
    public void eatAll(Collection<? extends Fruit> fruits) {}
    public void addApple(Collection<? super Apple> apples) {}
}
