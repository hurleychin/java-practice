package com.evil.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-06
 */
public class ThreadStatusDemo {
    public static void main(String[] args) throws InterruptedException {

/*        A thread is in the timed waiting state due to calling one of the following methods with a specified positive waiting time:
        Thread.sleep
        Object.wait with timeout
        Thread.join with timeout
        LockSupport.parkNanos
        LockSupport.parkUntil*/
        Thread timeWaitting = new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timeWaitting");
        timeWaitting.start();

/*        A thread is in the waiting state due to calling one of the following methods:
        Object.wait with no timeout
        Thread.join with no timeout
        LockSupport.park*/
        Thread waiting = new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusDemo.class) {
                    try {
                        ThreadStatusDemo.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "waiting");
        waiting.start();

        /*A thread in the runnable state is executing in the Java virtual machine
        but it may be waiting for other resources from the operating system such as processor*/
        Thread running=new Thread(new BlockedDemo(),"running");
        running.start();
        /* A thread in the blocked state is waiting for a monitor lock to enter a synchronized block/method
         or reenter a synchronized block/method after calling Object.wait.*/
        Thread blocked=new Thread(new BlockedDemo(), "blocked");
        blocked.start();

        while (true){
            Thread.sleep(1000);
            System.out.println(timeWaitting.getName() + " thread state:" + timeWaitting.getState());
            System.out.println(waiting.getName() + " thread state:" + waiting.getState());
            System.out.println(running.getName() + " thread state:" + running.getState());
            System.out.println(blocked.getName() + " thread state:" + blocked.getState());
        }
    }


    static class BlockedDemo extends Thread {
        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                for (;;);
            }
        }
    }
}
