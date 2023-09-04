package com.evil.structural.proxy;

public class Client {
    public static void main(String[] args) {
        // 创建文件代理
        FileAccess fileAccess = new FileAccessProxy("sensitive.txt", "admin");

        // 管理员可以访问文件
        fileAccess.accessFile();

        // 普通用户无法访问文件
        FileAccess userAccess = new FileAccessProxy("sensitive.txt", "user");
        userAccess.accessFile();
    }
}
