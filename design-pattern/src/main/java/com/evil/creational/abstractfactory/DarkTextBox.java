package com.evil.creational.abstractfactory;

/**
 * DarkTextBox
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体产品：Dark 风格文本框
class DarkTextBox implements TextBox {
    @Override
    public void display() {
        System.out.println("Dark text box is displayed.");
    }
}
