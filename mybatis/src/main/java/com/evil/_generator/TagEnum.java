package com.evil._generator;

/**
 * @author qinhulin
 * @date 2018-12-21
 */
public enum TagEnum {

    java("Java语言"),
    python("Python语言"),
    csharp("C#语言");

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    TagEnum(String title){
        this.title=title;
    }
}
