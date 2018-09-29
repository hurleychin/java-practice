package com.evil.concurrent.juc;

import com.evil.util.Console;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

/**
 * @author qinhu
 * @date 2018-09-20
 */
public class LockSupportDemo {

    public static void main(String[] args) throws InterruptedException {
        AtomicInteger count= new AtomicInteger(0);
        Thread block=new Thread(()->{
            for(;;){
                if(0== (TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis())%3)){
                    Console.out("park ->"+count.incrementAndGet());
                    LockSupport.park();
                    Console.out("end  ->"+count.get());
                }
            }
        },"block");
        block.start();

        for (int i=0;i<3;i++){
            Console.out("unpark->"+count.get());
            LockSupport.unpark(block);
            TimeUnit.SECONDS.sleep(5);
        }
    }
}

class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters
            = new ConcurrentLinkedQueue<Thread>();

    public void lock() {
        boolean wasInterrupted = false;
        Thread current = Thread.currentThread();
        waiters.add(current);

        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != current ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            if (Thread.interrupted()) // ignore interrupts while waiting
                wasInterrupted = true;
        }

        waiters.remove();
        if (wasInterrupted)          // reassert interrupt status on exit
            current.interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }
}

