package com.evil.creational.abstractfactory;

public class Client {
    public static void main(String[] args) {
        // 创建 Light 风格的 GUI 元素
        GUIFactory lightFactory = new LightGUIFactory();
        Button lightButton = lightFactory.createButton();
        TextBox lightTextBox = lightFactory.createTextBox();

        lightButton.paint();
        lightTextBox.display();

        // 创建 Dark 风格的 GUI 元素
        GUIFactory darkFactory = new DarkGUIFactory();
        Button darkButton = darkFactory.createButton();
        TextBox darkTextBox = darkFactory.createTextBox();

        darkButton.paint();
        darkTextBox.display();
    }
}
