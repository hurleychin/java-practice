package com.evil.behavioral.visitor;

/**
 * Circle
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体图形类 - 圆形
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
