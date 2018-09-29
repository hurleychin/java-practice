package com.evil.concurrent.atomic;

import com.evil.util.Console;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinhu
 * @date 2018-09-19
 */
public class AtomicIntegerDemo {
    final static  AtomicInteger atomicInteger = new AtomicInteger(1000);
    public static void main(String[] args) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(1);
                    atomicInteger.incrementAndGet();
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.await();
        Console.out(atomicInteger.intValue());
    }
}
