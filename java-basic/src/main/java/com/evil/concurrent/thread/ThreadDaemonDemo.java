package com.evil.concurrent.thread;

import com.evil.util.Console;

import java.util.concurrent.*;

/**
 * @author qinhu
 * @date 2018-08-12
 */
public class ThreadDaemonDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread=new Thread(()->{
            while (!Thread.currentThread().isInterrupted()){
                try {
                    Console.out("running...");
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread-demo");
        //The Java Virtual Machine exits when the only threads running are all daemon threads.
        // 1. 主角(用户线程)都死了，不管配角(守护线程)还活不活着,戏都会结束(JVM退出)
        // 2. 守护线程主要用来服务用户线程，一般设置较低的优先级 ,典型的守护线程:GC线程
        thread.setDaemon(true);
        thread.start();

        Console.out("main Thread is end! ");
    }

}
