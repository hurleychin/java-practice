package com.evil.structural.bridge;

// 形状抽象类
abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void draw();
}
