package com.evil.behavioral.visitor;

/**
 * AreaCalculator
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体访问者类 - 面积计算器
class AreaCalculator implements Visitor {
    double totalArea = 0;

    @Override
    public void visit(Circle circle) {
        double area = Math.PI * circle.getRadius() * circle.getRadius();
        totalArea += area;
        System.out.println("计算圆形面积: " + area);
    }

    @Override
    public void visit(Rectangle rectangle) {
        double area = rectangle.getWidth() * rectangle.getHeight();
        totalArea += area;
        System.out.println("计算矩形面积: " + area);
    }

    public double getTotalArea() {
        return totalArea;
    }
}
