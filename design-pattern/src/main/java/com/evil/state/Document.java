package com.evil.state;

public class Document {
    private DocumentState state;

    public Document() {
        // 默认状态为编辑状态
        state = new EditState();
    }

    public void setState(DocumentState newState) {
        state = newState;
    }

    public void editDocument() {
        state.editDocument();
    }

    public void saveDocument() {
        state.saveDocument();
    }
}
