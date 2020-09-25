package com.evil.pattern.event;

import java.util.EventObject;

/**
 * @author qinhulin on 2020-09-24
 */
public class SayHello extends EventObject {

    private SayHelloListener sayHelloListeners = null;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public SayHello(Object source) {
        super(source);
    }

    public void addListener(SayHelloListener sayHelloListener) {
        this.sayHelloListeners = sayHelloListener;
    }

    public void sayHello() {
        System.out.println("Hello");
        sayHelloListeners.someSaidHello(source);
    }
}
