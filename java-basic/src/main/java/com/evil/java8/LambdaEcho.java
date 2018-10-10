package com.evil.java8;

import com.evil.util.Console;

import java.util.Arrays;

/**
 * @author qinhu
 * @date 2018-08-12
 */
public class LambdaEcho {
    public static void main(String[] args) {
        Arrays.asList("a", "c", "b", "d").forEach(System.out::println);
    }


}
