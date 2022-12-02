package com.evil.passbyvalue;

/**
 * Java is always pass-by-value
 *
 * @author qinhu
 * @date 2018-08-24
 */
public class App {
    public static void main(String[] args) {

        Foo foo = new Foo();
        foo.setName("hello");

        int i = 100;

        Double d=100d;

        modifyReference(foo, i,d);
        System.out.println("after modifyReference:" + foo + "\t" + i+"\t"+d);
        modifyValue(foo, i,d);
        System.out.println("after modifyValue:" + foo + "\t" + i+"\t"+d);

    }

    private static void modifyReference(Foo a, int i,Double d) {
        a = null; //no effect
        i = -1;  //no effect
        d=0d;
    }

    private static void modifyValue(Foo b, int i,Double d) {
        b.setName("world");
        i = -1;
        d=0d;
    }
}
