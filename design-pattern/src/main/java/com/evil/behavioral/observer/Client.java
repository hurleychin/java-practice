package com.evil.behavioral.observer;

public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();

        subject.registerObserver(observer1);
        subject.registerObserver(observer2);

        subject.setState(10);
        // 输出：
        // 观察者状态更新为: 10
        // 观察者状态更新为: 10

        subject.setState(20);
        // 输出：
        // 观察者状态更新为: 20
        // 观察者状态更新为: 20

        subject.removeObserver(observer1);

        subject.setState(30);
        // 输出：
        // 观察者状态更新为: 30
    }
}
