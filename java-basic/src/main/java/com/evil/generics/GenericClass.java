package com.evil.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qinhulin
 * @date 5/13/18
 */
public class GenericClass<T>{

    private List<T> list=new ArrayList<>();

    public void addList(T key) {
        this.list.add(key);
    }

    public List<T> getKey() {
        return list;
    }

    public static void main(String[] args) {
        GenericClass<Double> genericClass=new GenericClass<>();
        genericClass.addList(0.001);
        List<? extends Number> values=genericClass.getKey();
       System.out.println(values);

    }

}
