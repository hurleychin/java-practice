package com.evil.concurrent;

import java.util.concurrent.*;

/**
 * @author qinhu
 * @date 2018-08-12
 */
public class ThreadDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread=new Thread(()->{
            while (true){
                try {
                    System.out.println(System.currentTimeMillis());
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"thread-demo");
        thread.start();

       ExecutorService executorService= Executors.newCachedThreadPool();
      Future<?> future= executorService.submit(()-> {
          try {
              TimeUnit.SECONDS.sleep(3);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return "hello";
      });
        System.out.println(future.get());
        executorService.shutdown();
    }

}
