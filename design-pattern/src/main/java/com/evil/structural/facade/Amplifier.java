package com.evil.structural.facade;

/**
 * Amplifier
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 子系统中的各个组件类
class Amplifier {
    public void on() {
        System.out.println("音响打开");
    }

    public void off() {
        System.out.println("音响关闭");
    }

    public void setSource(DVDPlayer dvdPlayer) {
        System.out.println("音响设置为 DVD 模式");
    }

    public void setSurroundSound() {
        System.out.println("音响设置为环绕声音效");
    }
}
