package com.evil.spring.aop.proxy;

import com.evil.util.Console;

/**
 * @author qinhu
 * @date 2018-09-30
 */
public class SimplePojo implements Pojo{
    @Override
    public void foo(String name) {
        // this next method invocation is a direct call on the 'this' reference
        this.bar(name);
    }

    public void bar(String name) {
        Console.out("Hello "+ name);
    }
}
