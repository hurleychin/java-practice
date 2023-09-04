package com.evil.creational.factorymethod;

public class Client {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        ShapeFactory rectangleFactory = new RectangleFactory();

        Shape circle = circleFactory.createShape();
        Shape rectangle = rectangleFactory.createShape();

        circle.draw();
        rectangle.draw();

    }
}
