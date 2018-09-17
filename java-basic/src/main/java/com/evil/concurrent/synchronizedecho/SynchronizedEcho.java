package com.evil.concurrent.synchronizedecho;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-13
 */
public class SynchronizedEcho {
    private int i=0;
    private static int j=0;
    private int m=0;
    private static int n=0;
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
       synchronized (SynchronizedEcho.class){ //全局锁
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

    public synchronized static  void staticSyncMethodInc(){ //全局锁
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        n++;
    }

    public static void main(String[] args) throws InterruptedException {
        SynchronizedEcho synchronizedEcho=new SynchronizedEcho();
        for(int i=0;i<1000;i++){
            new Thread(()->{
                synchronizedEcho.syncBlockInc();
                synchronizedEcho.syncMethodInc();
                staticSyncBlockInc();
                staticSyncMethodInc();
            }).start();
        }

        TimeUnit.SECONDS.sleep(10);
        System.out.println("i="+synchronizedEcho.i+",j="+j+",m="+synchronizedEcho.m+",n="+n);
        //output:
//        i=1000,j=1000,m=1000,n=1000
    }
}
