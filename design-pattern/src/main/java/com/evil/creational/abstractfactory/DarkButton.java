package com.evil.creational.abstractfactory;

/**
 * DarkButton
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体产品：Dark 风格按钮
class DarkButton implements Button {
    @Override
    public void paint() {
        System.out.println("Dark button is painted.");
    }
}
