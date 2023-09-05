package com.evil.creational.singleton;

public class Singleton {
    // 私有静态成员变量，用于存储唯一的实例
    private static Singleton instance;

    // 私有构造方法，防止外部实例化
    private Singleton() {
        // 可以在这里进行初始化操作
    }

    // 公有静态方法，用于获取实例
    public static Singleton getInstance() {
        // 使用延迟初始化，只在需要时创建实例
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // 其他方法
    public void doSomething() {
        System.out.println("Singleton 实例正在执行操作...");
    }
}

