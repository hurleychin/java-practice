package com.evil.reflection.dynamicproxy.demo;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class Mylog implements ILog {
    @Override
    public void log(String msg) {
        System.out.println("Log msg: "+msg);
    }
}
