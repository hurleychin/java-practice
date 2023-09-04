package com.evil.creational.factorymethod;

/**
 * Circle
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体产品：圆形
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制圆形");
    }
}
