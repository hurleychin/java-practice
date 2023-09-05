package com.evil.behavioral.visitor;

public class Client {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        AreaCalculator areaCalculator = new AreaCalculator();
        circle.accept(areaCalculator);
        rectangle.accept(areaCalculator);

        System.out.println("总面积: " + areaCalculator.getTotalArea());

        PerimeterCalculator perimeterCalculator = new PerimeterCalculator();
        circle.accept(perimeterCalculator);
        rectangle.accept(perimeterCalculator);

        System.out.println("总周长: " + perimeterCalculator.getTotalPerimeter());
    }
}
