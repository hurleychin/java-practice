package com.evil.concurrent.waitnotify.join;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-14
 */
public class ThreadJoin extends Thread{

    @Override
    public void run(){
        int count=10;
        try {
            while (count>0){
                System.out.println(count);
                TimeUnit.SECONDS.sleep(1);
                count--;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void join_() throws InterruptedException {
        synchronized (this){
            while (isAlive()){
                wait();
            }
        }
    }
}
