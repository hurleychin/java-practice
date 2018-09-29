package com.evil.concurrent.synchronizedecho;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinhu
 * @date 2018-09-13
 */
public class SynchronizedDemo {
    private int i=0;
    private static int j=0;
    private int m=0;
    private static int n=0;
    private static AtomicInteger a=new AtomicInteger();
    public void syncBlockInc(){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (this){//实例锁
            i++;
        }
    }
    public static void staticSyncBlockInc(){
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       synchronized (SynchronizedDemo.class){ //全局锁
           j++;
       }
    }

    public synchronized void syncMethodInc(){ //实例锁
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        m++;
    }

    public synchronized void syncMethodIncStatic(){ //实例锁
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        j++;
        a.incrementAndGet();
    }

    public synchronized static  void staticSyncMethodInc(){ //全局锁
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n++;
    }

    public static void main(String[] args) throws InterruptedException {
//        testSingleton();
        testMutiInstance();

    }

    private static void testSingleton() throws InterruptedException {
        SynchronizedDemo synchronizedDemo =new SynchronizedDemo();
        for(int i=0;i<1000;i++){
            new Thread(()->{
                synchronizedDemo.syncBlockInc();
                synchronizedDemo.syncMethodInc();
                staticSyncBlockInc();
                staticSyncMethodInc();
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("i="+ synchronizedDemo.i+",j="+j+",m="+ synchronizedDemo.m+",n="+n);
        //output:
//        i=1000,j=1000,m=1000,n=1000
    }

    private static void testMutiInstance() throws InterruptedException {
        for(int i=0;i<1000;i++){
            new Thread(()->{
                SynchronizedDemo synchronizedDemo =new SynchronizedDemo();
                synchronizedDemo.syncMethodIncStatic();
                SynchronizedDemo.staticSyncMethodInc();
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("j="+ SynchronizedDemo.j+",n="+ SynchronizedDemo.n+",a="+SynchronizedDemo.a.get());
        //output:
//        i=1000,j=1000,m=1000,n=1000
    }

}
