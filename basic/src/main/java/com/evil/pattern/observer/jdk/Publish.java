package com.evil.pattern.observer.jdk;

import java.util.Observable;

/**
 * @author qinhulin on 2018-06-30
 */
public class Publish extends Observable {

   public void broadcast(String msg){
       setChanged();
       notifyObservers(msg);
   }
}
