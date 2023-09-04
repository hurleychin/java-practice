package com.evil.structural.composite;

/**
 * Leaf
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // Leaf 叶子对象
class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子对象 " + name + " 执行操作");
    }
}
