package com.evil.reflection.dynamicproxy.demo;

import java.lang.reflect.Proxy;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class App {
    public static void main(String[] args) {
       ILog log=new Mylog();
       LogWithTimeProxy logWithTimeProxy=new LogWithTimeProxy(log);
       ILog logWithTime= (ILog)Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{ILog.class},logWithTimeProxy);
       logWithTime.log("Hello evil!");
    }
}
