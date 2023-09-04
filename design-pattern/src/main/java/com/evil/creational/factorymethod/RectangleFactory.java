package com.evil.creational.factorymethod;

/**
 * RectangleFactory
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体工厂：矩形工厂
class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}
