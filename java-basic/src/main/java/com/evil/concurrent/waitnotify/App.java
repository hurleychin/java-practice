package com.evil.concurrent.waitnotify;

import com.evil.concurrent.waitnotify.join.ThreadJoin;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 * @date 2018-09-14
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ThreadNotify threadNotify=new ThreadNotify();
        ThreadWait threadWait=new ThreadWait(threadNotify);
        ThreadWaitAnother threadWaitAnother=new ThreadWaitAnother(threadNotify);

        threadWait.start();
        threadWaitAnother.start();

        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        threadNotify.start();

        ThreadJoin threadJoin=new ThreadJoin();
        threadJoin.start();
        threadJoin.join_();
        System.out.println("end");
    }
}
