package com.evil.concurrent.volatileecho;

import java.util.concurrent.TimeUnit;

/**
 * @author qinhu
 */
public class VolatileNotSureAtomic {
    private volatile   static  int i=0;


    public static void main(String[] args) throws InterruptedException {
       for(int n=1;n<=1000;n++){
          Thread thread=new Thread(()->{
              try {
                  TimeUnit.MILLISECONDS.sleep(1);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              //i++不是原子操作
/*              15: getstatic     #11                 // Field i:I
              18: iconst_1
              19: iadd
              20: putstatic     #11                 // Field i:I*/
              i++;
          });
          thread.start();
       }
       TimeUnit.SECONDS.sleep(5);
        System.out.println(i); // out put : 995
    }

}
