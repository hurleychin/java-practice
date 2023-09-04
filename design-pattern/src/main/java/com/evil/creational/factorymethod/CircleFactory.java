package com.evil.creational.factorymethod;

// 具体工厂：圆形工厂
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

