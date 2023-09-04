package com.evil.structural.bridge;

// 具体形状类：圆形
class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void draw() {
        System.out.print("Drawing Circle with ");
        color.applyColor();
    }
}

