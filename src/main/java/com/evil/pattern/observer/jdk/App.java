package com.evil.pattern.observer.jdk;

/**
 * @author qinhulin on 2018-06-30
 */
public class App {
    public static void main(String[] args) {

        Publish publish=new Publish();

        Subscribe subscribe1 =new Subscribe();
        Subscribe subscribe2 =new Subscribe();
        Subscribe subscribe3 =new Subscribe();

        publish.addObserver(subscribe1);
        publish.addObserver(subscribe1);
        publish.addObserver(subscribe2);
        publish.addObserver(subscribe3);

        publish.broadcast("Hello man!");

    }
}
