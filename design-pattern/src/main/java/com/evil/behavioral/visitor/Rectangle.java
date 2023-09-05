package com.evil.behavioral.visitor;

/**
 * Rectangle
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体图形类 - 矩形
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
