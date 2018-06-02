package com.evil.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenericClassTest {

    GenericClass<String> genericString=new GenericClass();
    GenericClass<Integer> genericInteger=new GenericClass();

    @Before
    public void setKey(){
        genericString.setKey(new String("test"));
        genericInteger.setKey(new Integer(1));
    }

    @Test
    public void getKey() {
        System.out.println(genericString.getKey());
        System.out.println(genericInteger.getKey());
    }


}