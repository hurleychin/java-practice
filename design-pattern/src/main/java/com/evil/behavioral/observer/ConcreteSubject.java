package com.evil.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * ConcreteSubject
 *
 * @author qinhu
 * @version 1.0.0
 * @since 2023-09-05
 */ // 具体主题
class ConcreteSubject implements Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }
}
