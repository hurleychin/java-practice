package com.evil.concurrent.thread;

import com.evil.util.Console;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinhulin on 2018-09-29
 */
public class ThreadLocalDemo {
    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId=new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.incrementAndGet();
        }
    };
    // Returns the current thread's unique ID, assigning it if necessary
    private static int get(){
      return  threadId.get();
    }

    public static void main(String[] args) {
        ThreadLocal<String> threadLocal=new InheritableThreadLocal<>();
        threadLocal.set("main");
        for (int i=0;i<100;i++){
            new Thread(()->{
//                Console.out(ThreadLocalDemo.get());
                Console.out(threadLocal.get());
            }).start();

        }
    }


}
