package com.evil.behavioral.visitor;

/**
 * PerimeterCalculator
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体访问者类 - 周长计算器
class PerimeterCalculator implements Visitor {
    double totalPerimeter = 0;

    @Override
    public void visit(Circle circle) {
        double perimeter = 2 * Math.PI * circle.getRadius();
        totalPerimeter += perimeter;
        System.out.println("计算圆形周长: " + perimeter);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double perimeter = 2 * (rectangle.getWidth() + rectangle.getHeight());
        totalPerimeter += perimeter;
        System.out.println("计算矩形周长: " + perimeter);
    }

    public double getTotalPerimeter() {
        return totalPerimeter;
    }
}
