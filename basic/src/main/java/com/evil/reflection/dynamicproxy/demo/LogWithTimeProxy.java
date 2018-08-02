package com.evil.reflection.dynamicproxy.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class LogWithTimeProxy implements InvocationHandler {

    private ILog log;

    public LogWithTimeProxy(ILog log){
       this.log=log;
    }



    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("==============="+new Date()+"============");
        method.invoke(log,args);
        return null;
    }
}
