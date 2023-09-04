package com.evil.behavioral.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * TextEditor
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 原发器类，表示文本编辑器
class TextEditor {
    private String text;
    private List<TextEditorMemento> history = new ArrayList<>();

    public void setText(String text) {
        this.text = text;
        history.add(new TextEditorMemento(text));
    }

    public String getText() {
        return text;
    }

    public void undo() {
        if (history.size() > 1) {
            history.remove(history.size() - 1);
            text = history.get(history.size() - 1).getText();
        }
    }
}
