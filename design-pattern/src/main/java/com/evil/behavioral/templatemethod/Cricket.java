package com.evil.behavioral.templatemethod;

/**
 * Cricket
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体子类实现算法的具体步骤
class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }
}
