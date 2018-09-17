package com.evil.concurrent.thread;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-07
 */
public class ThreadInterruptDemo {
    /**
     * volatile关键字保证可见性，如果没有，线程不会停止
     */
    private static /*volatile*/ boolean isStop=false;

    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(() -> {
//             while (true){
//                 try {
//                     System.out.println("before InterruptedException:" + Thread.currentThread().isInterrupted());
//
//                     // 等于执行Thread.currentThread().isInterrupted(ClearInterrupted)
//                     System.out.println(Thread.interrupted());
//
//                     TimeUnit.SECONDS.sleep(3);
//
//                     // 抛InterruptedException异常也会ClearInterrupted
//                 } catch (InterruptedException e) {
//                     System.out.println("after InterruptedException:" + Thread.currentThread().isInterrupted());
//                     e.printStackTrace();
//                 }
//             }
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("Thread is running!");
            }
            while (Thread.currentThread().isInterrupted()){
                System.out.println("Thread is be interrupted! but continue running...");
            }
        });
        thread.start();

        TimeUnit.SECONDS.sleep(5);
        thread.interrupt();

        new Thread(() -> {
            int i=0;
            while (!isStop){
//                if(isStop){ System.out.println("thread need to stop!");
//                   break;
//                }
                System.out.println("thread is running! i="+i);
                i++;
            }
        }).start();


        TimeUnit.SECONDS.sleep(3);
        isStop=true;

//        thread.suspend();
//        System.out.println("after suspend:"+thread.getState());
//
//        thread.resume();
//        System.out.println("after resume:"+thread.getState());

//        thread.stop();
//        System.out.println("after stop:" + thread.getState());
    }
}
