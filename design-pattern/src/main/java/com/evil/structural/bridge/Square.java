package com.evil.structural.bridge;

/**
 * Square
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体形状类：正方形
class Square extends Shape {
    public Square(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Square with ");
        color.applyColor();
    }
}
