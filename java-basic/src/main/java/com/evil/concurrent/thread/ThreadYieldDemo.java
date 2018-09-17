package com.evil.concurrent.thread;

/**
 * @author qinhu
 * @date 2018-09-16
 */
public class ThreadYieldDemo implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread yieldThread = new Thread(new ThreadYieldDemo(),"thread-yield");
        Thread noYieldThread = new Thread(new ThreadNoYield(),"thread-no-yield");
        yieldThread.start();
        noYieldThread.start();
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i > 5) {
                Thread.yield();
            }
            System.out.println(Thread.currentThread().getName() + "-->Inside ThreadYield " + i);
        }
    }

}
class ThreadNoYield implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-->Inside ThreadNoYield " + i);
        }
    }
}