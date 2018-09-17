package com.evil.concurrent.juc;

import com.evil.util.Console;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author qinhu
 * @date 2018-09-17
 */
public class ReentrantReadWriteLockDemo {

    public static void main(String[] args) throws InterruptedException {

        final int MAX_COUNT=1000;

        SafeCachedData<String> safeCachedData = new SafeCachedData<>();
        UnSafeCachedData<String> unSafecachedData = new UnSafeCachedData<>();

        CountDownLatch latch = new CountDownLatch(1);
//        CountDownLatch done = new CountDownLatch(MAX_COUNT);
        CyclicBarrier barrier=new CyclicBarrier(MAX_COUNT,()->{
            Console.out("All done!");
            Console.out("SafeCachedData  " + safeCachedData.data);
            Console.out("UnSafeCachedData" + unSafecachedData.data);
        });

        for (int i = 0; i < MAX_COUNT; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    latch.await();
                    String v = String.valueOf(Calendar.getInstance().get(Calendar.SECOND));
                    Console.out("UnSafeCachedData add " + unSafecachedData.processCachedData(v));
                    Console.out("SafeCachedData add " + safeCachedData.processCachedData(v));
//                    done.countDown();
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, "CachedData-" + i).start();
        }

        latch.countDown();
//       done.await();

    }

}

class SafeCachedData<T> {

    List<T> data = new ArrayList<>(); //unsafe

    final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public T processCachedData(T t) {
        rwl.readLock().lock(); //读锁，不可写入
        try {
            if (!data.contains(t)) {
                // Must release read lock before acquiring write lock
                rwl.readLock().unlock(); //unlock readlock,can write
                rwl.writeLock().lock(); //lock write
                try {
                    // Recheck state because another thread might have
                    // acquired write lock and changed state before we did.
                    if (!data.contains(t)) {
                        data.add(t);
                    }
                    // Downgrade by acquiring read lock before releasing write lock
                    rwl.readLock().lock();
                } finally {
                    rwl.writeLock().unlock(); // Unlock write, still hold read
                }
            }
            return t;
        } finally {
            rwl.readLock().unlock();
        }
    }
}

class UnSafeCachedData<T> {

    List<T> data = new ArrayList<>(); //unsafe

    public T processCachedData(T t) {
        if (!data.contains(t)) {
            data.add(t);
        }
        return t;
    }
}
/*ouput:
        [2018-09-17 11:25:33 916]-[main,5,main] SafeCachedData  [33]
        [2018-09-17 11:25:33 916]-[main,5,main] UnSafeCachedData[null, 33, 33]*/
