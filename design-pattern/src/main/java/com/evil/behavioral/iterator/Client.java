package com.evil.behavioral.iterator;

import java.util.Iterator;

public class Client {
    public static void main(String[] args) {
        // 创建自定义集合
        String[] names = { "Alice", "Bob", "Charlie", "David" };
        MyCollection<String> collection = new MyList<>(names);

        // 使用迭代器遍历集合
        Iterator<String> iterator = collection.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println("Name: " + name);
        }
    }
}
