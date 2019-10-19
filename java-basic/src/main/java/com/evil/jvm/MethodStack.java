package com.evil.jvm;

/** 方法栈
 * @author qinhulin
 * @date 2019-02-20
 */
public class MethodStack {
    public static void main(String[] args) {
       a(); // stack: c b a main
       d(); // stack  d main
    }

    public static void a(){
        System.out.println("Method a");
        b();
    }

    private static void b() {
        System.out.println("Method b");
        c();
    }

    private static void c(){
        System.out.println("Method c");
    }

    private static void d(){
        System.out.println("Method d");
    }

}
