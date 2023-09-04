package com.evil.behavioral.state;

/**
 * Main
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-03
 */
public class Main {
    public static void main(String[] args) {
        Document document = new Document();

        document.editDocument();  // 输出：Document is currently in edit mode. You can make changes.
        document.saveDocument();  // 输出：Saving the document in edit mode.

        // 切换文档状态为只读状态
        document.setState(new ReadOnlyState());

        document.editDocument();  // 输出：Document is currently in read-only mode. Editing is not allowed.
        document.saveDocument();  // 输出：Cannot save the document in read-only mode.
    }
}
