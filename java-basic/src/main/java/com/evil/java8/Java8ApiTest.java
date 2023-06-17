package com.evil.java8;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author qinhu
 * @date 2018-08-12
 */
public class Java8ApiTest {

    @Test
    public void testOptional() {
        assertEquals(Optional.ofNullable(null).orElse(0), 0);
    }

    @Test
    public void testStream() {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Orange");
        List<String> b = fruits.stream().filter(s -> s.startsWith("B")).collect(Collectors.toList());
        System.out.println(b);

        System.out.println("------------------------");

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
        System.out.println("------------------------");
        numbers.stream().reduce((x, y) -> x + y).ifPresent(System.out::println);
        System.out.println("------------------------");

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        numbers2.stream().map(x -> x * x).sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("------------------------");

        List<String> words = Arrays.asList("Hello", "World");
        words.stream().flatMap(s -> Arrays.stream(s.split("")).map(String::toUpperCase)).forEach(System.out::println);
        System.out.println("------------------------");


    }
}



