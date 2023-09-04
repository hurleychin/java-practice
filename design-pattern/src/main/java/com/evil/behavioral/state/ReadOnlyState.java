package com.evil.behavioral.state;

/**
 * ReadOnlyState
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */ // 具体的只读文档状态类
public class ReadOnlyState implements DocumentState {
    @Override
    public void editDocument() {
        System.out.println("Document is currently in read-only mode. Editing is not allowed.");
    }

    @Override
    public void saveDocument() {
        System.out.println("Cannot save the document in read-only mode.");
    }
}
