package com.evil.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import static org.springframework.web.context.WebApplicationContext.SCOPE_REQUEST;

/**
 * @author qinhu
 * @date 2018-10-13
 */
@RestController
@Scope(value = SCOPE_REQUEST)
public class HelloController {

    private  ConcurrentHashMap<String,String> hashMap=new ConcurrentHashMap<>();

    @GetMapping("/hello")
    public String handle(Model model) {
        model.addAttribute("message", "Hello World!");
        hashMap.put(String.valueOf(new Random().nextInt(100)), String.valueOf(new Date()));
        return hashMap.toString();
    }
}
