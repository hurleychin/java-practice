package com.evil.creational.factorymethod;

/**
 * Rectangle
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体产品：矩形
class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("绘制矩形");
    }
}
