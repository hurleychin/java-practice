package com.evil.creational.abstractfactory;

/**
 * LightGUIFactory
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体工厂：Light 风格工厂
class LightGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public TextBox createTextBox() {
        return new LightTextBox();
    }
}
