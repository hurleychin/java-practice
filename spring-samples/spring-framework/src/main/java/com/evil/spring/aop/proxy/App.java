package com.evil.spring.aop.proxy;

import com.evil.util.Console;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author qinhu
 * @date 2018-09-30
 */
public class App {
    public static void main(String[] args) {
//        aop();
        aspectJ();
    }

    private static void aop() {
        ProxyFactory factory = new ProxyFactory(new SimplePojo());
        factory.addInterface(Pojo.class);
        factory.setExposeProxy(true);
        factory.addAdvice(new MethodBeforeAdvice() {
            @Override
            public void before(Method method, Object[] args, Object target) throws Throwable {
                Console.out("method="+method);
                Console.out("args="+ Arrays.toString(args));
                Console.out("target="+target);
            }
        });

        Pojo pojo = (Pojo) factory.getProxy();

        // this is a method call on the proxy!
        pojo.foo("Evil");
    }

    private static void aspectJ(){
        AspectJProxyFactory factory = new AspectJProxyFactory(SimplePojo.class);

// add an aspect, the class must be an @AspectJ aspect
// you can call this as many times as you need with different aspects
        factory.addAspect(SimpleAspectJ.class);

// you can also add existing aspect instances, the type of the object supplied must be an @AspectJ aspect
//        factory.addAspect(usageTracker);

// now get the proxy object...
        Pojo proxy = factory.getProxy();
        proxy.foo("Evil");
    }
}
