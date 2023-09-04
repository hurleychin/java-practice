package com.evil.creational.abstractfactory;

/**
 * GUIFactory
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 抽象工厂接口
interface GUIFactory {
    Button createButton();

    TextBox createTextBox();
}
