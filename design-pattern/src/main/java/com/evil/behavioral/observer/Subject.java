package com.evil.behavioral.observer;

/**
 * Subject
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 主题接口
interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
