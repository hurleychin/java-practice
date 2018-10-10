package com.evil.spring.aop.xml;

import com.evil.util.Console;

import java.util.Random;

/**
 * @author qinhu
 * @date 2018-10-09
 */
public class BarImpl implements IBar {
    @Override
    public String sayHello(String name) throws InterruptedException {
        Thread.sleep(new Random().nextInt(1000));
        return "Hello "+name;
    }
}
