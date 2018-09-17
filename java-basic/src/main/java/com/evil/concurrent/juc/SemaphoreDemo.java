package com.evil.concurrent.juc;

import com.evil.util.Console;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-17
 */
public class SemaphoreDemo {

    public static void main(String[] args) {
       Semaphore semaphore=new Semaphore(3);
       for(int i=0;i<10;i++){
           new Thread(()->{
               try {
                   if(semaphore.tryAcquire(500, TimeUnit.MILLISECONDS)){
                       Console.out("acquire success,running");
                       Thread.sleep(new Random().nextInt(1000));
                   }else {
                       Console.out("acquire fail!");
                   }
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   semaphore.release();
               }
           }).start();
       }
    }
}

