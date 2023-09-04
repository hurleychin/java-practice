package com.evil.structural.composite;

public class Client {
    public static void main(String[] args) {
        // 创建叶子对象
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        // 创建组合对象
        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        // 调用组合对象的操作，会递归执行所有子对象的操作
        composite.operation();
    }
}
