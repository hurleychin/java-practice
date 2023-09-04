package com.evil.structural.facade;

/**
 * Projector
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */
class Projector {
    public void on() {
        System.out.println("投影仪打开");
    }

    public void off() {
        System.out.println("投影仪关闭");
    }

    public void setInput(DVDPlayer dvdPlayer) {
        System.out.println("投影仪设置输入源为 DVD 播放器");
    }
}
