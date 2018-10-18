package com.evil.spring.aop.aspectj;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @author qinhu
 * @date 2018-10-08
 */
@Component
@EnableAspectJAutoProxy
public class FooService {
    public Integer execute(Integer id) throws Exception {
        try {
            if (id < 1) {
                throw new Exception("id must bigger than 1");
            }
        } finally {
            System.out.println("FooService.execute(" + id + ")");
        }
        return id;
    }

    public String execute(String name) throws Exception {
        System.out.println("FooService.execute(" + name + ")");
        return name;
    }
}
