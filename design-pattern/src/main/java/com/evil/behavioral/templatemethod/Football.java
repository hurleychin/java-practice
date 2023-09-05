package com.evil.behavioral.templatemethod;

/**
 * Football
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */
class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
