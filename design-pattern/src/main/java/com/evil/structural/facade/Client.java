package com.evil.structural.facade;

public class Client {
    public static void main(String[] args) {
        HomeTheaterFacade homeTheater = new HomeTheaterFacade();

        // 观看电影
        homeTheater.watchMovie("The Avengers");

        // 结束电影
        homeTheater.endMovie();
    }
}
