package com.evil.behavioral.memento;

public class Client {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        // 输入文本
        editor.setText("第一行文本");
        System.out.println("当前文本: " + editor.getText());

        // 保存备忘录
        editor.setText("第二行文本");
        System.out.println("当前文本: " + editor.getText());

        // 撤销操作
        editor.undo();
        System.out.println("撤销后的文本: " + editor.getText());
    }
}
