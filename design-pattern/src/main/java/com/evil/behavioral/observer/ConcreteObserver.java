package com.evil.behavioral.observer;

/**
 * ConcreteObserver
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体观察者
class ConcreteObserver implements Observer {
    private int observerState;

    @Override
    public void update(int state) {
        observerState = state;
        System.out.println("观察者状态更新为: " + observerState);
    }
}
