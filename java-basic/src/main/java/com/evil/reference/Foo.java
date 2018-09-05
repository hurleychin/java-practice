package com.evil.reference;

/**
 * @author qinhu
 * @date 2018-08-24
 */
public class Foo {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Foo{" +
                "name='" + name + '\'' +
                '}';
    }
}
