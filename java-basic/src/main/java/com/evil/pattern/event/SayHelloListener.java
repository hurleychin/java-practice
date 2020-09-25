package com.evil.pattern.event;

import java.util.EventListener;

/**
 * @author qinhulin on 2020-09-24
 */
public interface SayHelloListener extends EventListener {

    void someSaidHello(Object source);

}
