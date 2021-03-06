package com.evil.pattern.observer;

public class User implements Observer{
    private Observable observable=null;
    public User(Observable observable){
        this.observable=observable;
    }
    @Override
    public void update(boolean inStock) {
        if(inStock){
            buyDress();
            unsubscribe();
        }
    }

    public void buyDress(){
        System.out.println("Got my new Red Dress");
    }

    public void unsubscribe(){
        observable.removeObserver(this);
    }
}

