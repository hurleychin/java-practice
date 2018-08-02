package com.evil.dubbo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class Provider {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"META-INF/dubbo-demo-provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
    }
}
