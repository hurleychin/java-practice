package com.evil.creational.singleton;

/**
 * SingletonExample
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */
public class Client {
    public static void main(String[] args) {
        // 获取 Singleton 实例
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // 验证是否为同一实例
        if (singleton1 == singleton2) {
            System.out.println("两者是同一实例。");
        }

        // 使用单例实例进行操作
        singleton1.doSomething();
    }
}
