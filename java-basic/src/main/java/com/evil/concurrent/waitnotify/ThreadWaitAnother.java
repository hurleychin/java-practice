package com.evil.concurrent.waitnotify;

/**
 * @author qinhu
 * @date 2018-09-14
 */
public class ThreadWaitAnother extends Thread {
    private Object lock;

    public ThreadWaitAnother(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("ThreadWaitAnother wait!");
                lock.wait(200);
                System.out.println("ThreadWaitAnother=============>ThreadNotify work result,a=" + ((ThreadNotify) lock).a);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
