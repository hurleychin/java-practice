package com.evil.concurrent.volatileecho;

/**
 * @author qinhu
 * @date 2018-09-10
 */
public class OrderAccessEcho {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        for (int i=0;i<1000000;i++) {
            x=0;
            y=0;
            a=0;
            b=0;

            Thread t1 = new Thread(() -> {
                a = 1;
                x = b;
            });
            Thread t2 = new Thread(() -> {
                b = 1;
                y = a;
            });
            t1.start();
            t2.start();
            t1.join();
            t2.join();
            System.out.println("x=" + x + ",y=" + y);

            /*
            * x=0,y=1  //more than 10,000 matches
             * x=1,y=0 //8934 matches
             * x=1,y=1 //3 matches
             */
        }
    }
}
