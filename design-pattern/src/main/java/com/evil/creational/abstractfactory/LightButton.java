package com.evil.creational.abstractfactory;

// 具体产品：Light 风格按钮
class LightButton implements Button {
    @Override
    public void paint() {
        System.out.println("Light button is painted.");
    }
}

