package com.evil.generics;

/**
 * @author qinhulin
 * @date 5/13/18
 */
public class GenericClass<T>{

    private T key;

    public void setKey(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

}
