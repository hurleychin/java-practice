package com.evil.concurrent.thread;

import com.evil.util.Console;

/**
 * @author qinhu
 * @date 2018-09-17
 * 线程组表示一组线程。此外，线程组还可以包括其他线程组。线程组形成一个树，其中除了初始线程组以外的每个线程组都有一个父线程。
 */

public class ThreadGroupDemo {
    public static void main(String[] args) throws InterruptedException {


        ThreadGroup threadGroup = new ThreadGroup("MyThreadGroup");
        threadGroup.setDaemon(true);
        threadGroup.setMaxPriority(2);
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            String taskName = "Task-" + i;
            threads[i] = new Thread(threadGroup, new Runnable() {
                @Override
                public void run() {
                    Console.out("running...");
                }
            },
                    "task"+i);
            threads[i].start();
        }
        for(Thread thread:threads){
            thread.join();
        }

        System.out.println("All threads finished their tasks ");
    }
}
