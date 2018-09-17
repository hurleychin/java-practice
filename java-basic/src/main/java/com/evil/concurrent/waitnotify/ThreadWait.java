package com.evil.concurrent.waitnotify;

/**
 * @author qinhu
 * @date 2018-09-14
 */
public class ThreadWait extends Thread {
    private Object lock;

    public ThreadWait(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("ThreadWait wait!");
                lock.wait();
                System.out.println("ThreadWait=========> ThreadNotify work result,a=" + ((ThreadNotify) lock).a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
