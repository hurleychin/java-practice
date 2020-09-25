package com.evil.pattern.event;

/**
 * @author qinhulin on 2020-09-24
 */
public class App {


    public static void main(String[] args) {

        SayHello sayHello = new SayHello(App.class);

        sayHello.addListener(source -> System.out.println(source + ": SayHello"));

        sayHello.sayHello();


    }
}
