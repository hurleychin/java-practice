package com.evil.structural.facade;

/**
 * HomeTheaterFacade
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-04
 */ // 外观类，提供了一个简化接口来控制音响系统
class HomeTheaterFacade {
    private Amplifier amplifier;
    private DVDPlayer dvdPlayer;
    private Projector projector;
    private Screen screen;

    public HomeTheaterFacade() {
        this.amplifier = new Amplifier();
        this.dvdPlayer = new DVDPlayer();
        this.projector = new Projector();
        this.screen = new Screen();
    }

    public void watchMovie(String movie) {
        System.out.println("准备观看电影...");
        screen.down();
        projector.on();
        projector.setInput(dvdPlayer);
        amplifier.on();
        amplifier.setSource(dvdPlayer);
        amplifier.setSurroundSound();
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        System.out.println("电影结束，关闭音响系统...");
        dvdPlayer.off();
        amplifier.off();
        projector.off();
        screen.up();
    }
}
