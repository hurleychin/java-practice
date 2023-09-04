package com.evil.structural.flyweight;

public class Client {
    public static void main(String[] args) {
        CharFlyweightFactory factory = new CharFlyweightFactory();
        TextEditor editor = new TextEditor(factory);

        // 构建文本，使用享元字符
        editor.appendText('H');
        editor.appendText('e');
        editor.appendText('l');
        editor.appendText('l');
        editor.appendText('o');
        editor.appendText(' ');
        editor.appendText('W');
        editor.appendText('o');
        editor.appendText('r');
        editor.appendText('l');
        editor.appendText('d');
        editor.appendText('!');

        editor.printText();
    }
}
