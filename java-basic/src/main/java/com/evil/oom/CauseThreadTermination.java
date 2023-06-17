package com.evil.oom;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * CauseThreadTermination
 *
 * @author qinhu
 * @version 0.0.1
 * @since 2023-06-10
 */
public class CauseThreadTermination {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        list.add("a");
                        System.out.println("thread is running");
                    } catch (Throwable e) {
                        e.printStackTrace();
                        System.out.println("thread is stopped");
                        break;
                    }
                }
            }
        } );
        thread.start();
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
