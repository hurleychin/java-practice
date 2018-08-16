package com.evil.lambda;

import java.util.Arrays;

/**
 * @author qinhu
 * @date 2018-08-12
 */
public class LambdaDemo {
    public static void main(String[] args) {
        Arrays.asList("a", "c", "b", "d").forEach(System.out::println);
    }
}
