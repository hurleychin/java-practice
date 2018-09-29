package com.evil.string;

import com.evil.util.Console;

import java.util.StringTokenizer;

/**
 * @author qinhu
 * @date 2018-09-19
 */
public class StringTokenizerDemo {
    public static void main(String[] args) {
        StringTokenizer stringTokenizer=new StringTokenizer("This is a test"," ");
        while (stringTokenizer.hasMoreTokens()){
            Console.out(stringTokenizer.nextToken());
        }
    }
}
