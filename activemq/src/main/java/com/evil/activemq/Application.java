package com.evil.activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

/**
 * @author qinhulin
 * @date 2020-08-15
 */

public class Application {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:applicationContext.xml");

    }
}
