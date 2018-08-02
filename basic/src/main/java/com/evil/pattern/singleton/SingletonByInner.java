package com.evil.pattern.singleton;

/**
 *  巧妙的内部类的懒汉式实现
 */
public class SingletonByInner {

    private SingletonByInner(){}

    public final static SingletonByInner getInstance(){
        return SingletonHolder.instance;
    }

    private static class SingletonHolder{
      private static final SingletonByInner instance=new SingletonByInner();
    }

}
