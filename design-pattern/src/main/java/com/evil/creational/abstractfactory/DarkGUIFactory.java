package com.evil.creational.abstractfactory;

/**
 * DarkGUIFactory
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 具体工厂：Dark 风格工厂
class DarkGUIFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public TextBox createTextBox() {
        return new DarkTextBox();
    }
}
