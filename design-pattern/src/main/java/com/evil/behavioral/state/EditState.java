package com.evil.behavioral.state;

/**
 * EditState
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */ // 具体的文档编辑状态类
public class EditState implements DocumentState {
    @Override
    public void editDocument() {
        System.out.println("Document is currently in edit mode. You can make changes.");
    }

    @Override
    public void saveDocument() {
        System.out.println("Saving the document in edit mode.");
    }
}
