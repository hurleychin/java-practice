package com.evil.structural.flyweight;

/**
 * TextEditor
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 文本编辑器
class TextEditor {
    private CharFlyweightFactory factory;
    private String text;

    public TextEditor(CharFlyweightFactory factory) {
        this.factory = factory;
        this.text = "";
    }

    public void appendText(char symbol) {
        CharFlyweight charFlyweight = factory.getCharFlyweight(symbol);
        text += charFlyweight.getSymbol();

    }

    public void printText() {
        System.out.println("文本内容: " + text);
    }
}
