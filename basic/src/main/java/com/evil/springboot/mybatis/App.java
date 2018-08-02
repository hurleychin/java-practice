package com.evil.springboot.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.evil.springboot.mybatis.mapper")
public class App{
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
