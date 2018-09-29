package com.evil.concurrent.juc;

import com.evil.util.Console;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-21
 */
public class ExchangerDemo {
    private static final Exchanger<String> exgr = new Exchanger<String>();

    public static void main(String[] args) {

       new  Thread(()->{
                try {
                    String data = "AK47";
                    Console.out("AK47 is making... ");
                    TimeUnit.SECONDS.sleep(1);
                    String exres=exgr.exchange(data);
                    Console.out(" get "+exres);
                } catch (InterruptedException e) {
                }
        },"Soviet").start();

        new  Thread(()->{
            try {
                String data = "Food";
                Console.out("Food is growing up... ");
                TimeUnit.SECONDS.sleep(3);
                String exres=exgr.exchange(data);
                Console.out(" get "+exres);
            } catch (InterruptedException e) {
            }
        },"China").start();
    }

}
