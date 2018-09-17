package com.evil.random;

import java.util.Random;

/**
 * @author qinhu
 * @date 2018-09-16
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random=new Random();
        for (int i=0;i<100;i++){
            System.out.println("=======================\nint:"+random.nextInt(10));
            System.out.println("double:"+random.nextDouble());
            System.out.println("long:"+random.nextLong());
        }
    }
}
