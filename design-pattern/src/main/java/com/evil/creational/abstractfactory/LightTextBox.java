package com.evil.creational.abstractfactory;

/**
 * LightTextBox
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体产品：Light 风格文本框
class LightTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Light text box is displayed.");
    }
}
