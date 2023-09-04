package com.evil.structural.flyweight;

/**
 * CharConcreteFlyweight
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体享元对象，表示字符
class CharConcreteFlyweight implements CharFlyweight {
    private char symbol;

    public CharConcreteFlyweight(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void print() {
        System.out.print(symbol);
    }

    @Override
    public char getSymbol() {
       return this.symbol;
    }


}
