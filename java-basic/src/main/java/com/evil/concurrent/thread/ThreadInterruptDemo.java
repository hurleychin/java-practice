package com.evil.concurrent.thread;

import com.evil.util.Console;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-07
 *
 */
public class ThreadInterruptDemo {

    /**
     *
     * 1. thread.interrupt()方法将会设置该线程的中断标记位为true，具体该线程是终止或继续运行，取决于线程本身。
     * 2. Thread.interrupted()=Thread.currentThread().isInterrupted(ClearInterrupted),会清除中断标记位(即中断标记位重置为false),
     *    通常使用Thread.currentThread().isInterrupted()判断中断标记位(因为该方法不会修改标记状态)
     * 3.If this thread is blocked in an invocation of the wait(), wait(long), or wait(long, int) methods of the Object class,
     *    or of the join(), join(long), join(long, int), sleep(long), or sleep(long, int), methods of this class,
     *    then its interrupt status will be cleared and it will receive an InterruptedException.
     */

    public static void main(String[] args) throws IOException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is running!");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {  // Clears interrupted status!
                    e.printStackTrace();
                    //抛出InterruptedException时会重置中断标记位
                    Thread.currentThread().interrupt();
                }
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("Thread is be interrupted! but continue running...");
            }
        }, "ToBeInterruptThread");
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
