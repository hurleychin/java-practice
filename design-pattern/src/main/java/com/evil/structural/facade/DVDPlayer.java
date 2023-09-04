package com.evil.structural.facade;

/**
 * DVDPlayer
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */
class DVDPlayer {
    public void on() {
        System.out.println("DVD 播放器打开");
    }

    public void off() {
        System.out.println("DVD 播放器关闭");
    }

    public void play(String movie) {
        System.out.println("正在播放电影：" + movie);
    }
}
