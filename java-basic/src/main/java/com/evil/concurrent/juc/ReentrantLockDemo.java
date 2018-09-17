package com.evil.concurrent.juc;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class ReentrantLockDemo<E> {
    private final Lock lock = new ReentrantLock();

    private final List<E> list = new ArrayList<E>();


    public void set(E o) throws InterruptedException {

        lock.lock();
        try {
            list.add(o);
            System.out.println("Adding element by thread: " + Thread.currentThread().getName());
        } finally {
            lock.unlock();
        }

//        if (lock.tryLock(100, TimeUnit.MICROSECONDS)) {
//            try {
//                list.add(o);
//                System.out.println("Adding element by thread: " + Thread.currentThread().getName());
//            } finally {
//                lock.unlock();
//            }
//        }else {
//            System.out.println("thread: " + Thread.currentThread().getName() +" try lock fail!");
//        }
}

    public static void main(String[] args) throws InterruptedException {

        final ReentrantLockDemo<String> lockExample = new ReentrantLockDemo<String>();

        for (int m = 0; m < 10; m++) {
            new Thread(() -> {
                try {
                    Thread.sleep(10);
                    lockExample.set(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }, "Thread---" + m).start();
        }

        Thread.sleep(1000);

        System.out.println(lockExample.list);

    }
}
