package com.evil.concurrent.juc;

import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author qinhu
 * @date 2018-09-16
 */
public class ConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        BoundedBuffer boundedBuffer=new BoundedBuffer();
        Random random=new Random();
        Thread putThread=new Thread(()->{
            for (;;){
                    try {
                        boundedBuffer.put(String.valueOf(System.currentTimeMillis()));
                        Thread.sleep(random.nextInt(3000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        });
        putThread.start();

        for(;;){
            System.out.println(boundedBuffer.take());
            Thread.sleep(random.nextInt(3000));
        }




    }
}
class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull  = lock.newCondition();
    final Condition notEmpty = lock.newCondition();

    final Object[] items = new Object[10];
    int putptr, takeptr, count;

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try {
            while (count == items.length){
                System.out.println("put线程await...");
                notFull.await();
            }
            items[putptr] = x;
            if (++putptr == items.length) putptr = 0;
            ++count;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0){
                System.out.println("take线程await...");
                notEmpty.await();
            }
            Object x = items[takeptr];
            if (++takeptr == items.length) takeptr = 0;
            --count;
            notFull.signal();
            return x;
        } finally {
            lock.unlock();
        }
    }


}
