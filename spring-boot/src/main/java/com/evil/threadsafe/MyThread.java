package com.evil.threadsafe;

import java.util.concurrent.CountDownLatch;

class MyThread extends Thread {
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;
    private final Runnable task;

    public MyThread(String name, CountDownLatch startSignal,CountDownLatch doneSignal,Runnable task) {
        super(name);
        this.startSignal = startSignal;
        this.doneSignal=doneSignal;
        this.task=task;
    }

    @Override
    public void run() {
        try {
            startSignal.await(); // 等待启动信号
            try {
                task.run();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                doneSignal.countDown(); // 通知完成
            }

            // 执行其他操作
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}