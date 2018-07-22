package com.evil.pattern.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * @author qinhulin on 2018-06-30
 */
public class Subscribe implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(this+" copy that [ "+ arg +" ] from "+o);
    }
}
