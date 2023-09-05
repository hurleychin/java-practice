package com.evil.behavioral.templatemethod;

/**
 * Game
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 抽象类定义了算法的骨架
abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    // 模板方法，定义了算法的基本结构
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}
