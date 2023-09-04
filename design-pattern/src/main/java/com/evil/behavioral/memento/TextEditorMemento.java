package com.evil.behavioral.memento;

/**
 * TextEditorMemento
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 备忘录类，用于保存文本编辑器的状态
class TextEditorMemento {
    private String text;

    public TextEditorMemento(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
