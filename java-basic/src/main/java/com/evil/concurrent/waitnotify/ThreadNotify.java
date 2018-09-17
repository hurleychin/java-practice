package com.evil.concurrent.waitnotify;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-14
 */
public class ThreadNotify extends Thread {

    public int a = 0;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 100; i++) {
                a++;
                try {
                    TimeUnit.MILLISECONDS.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                System.out.println("ThreadNotify work,a="+a);
            }
            System.out.println("ThreadNotify notify!");
            this.notifyAll();
        }
    }
}
