package com.evil.reference;

/**
 * @author qinhu
 * @date 2018-08-24
 */
public class App {
    public static void main(String[] args) {
        Foo foo=new Foo();
        foo.setName("hello");
        changeReference(foo);
        System.out.println("after changeReference:"+ foo.toString());
        modifyReference(foo);
        System.out.println("after modifyReference:"+ foo.toString());
    }

    private static void changeReference(Foo a){
        Foo foo=new Foo();
        foo.setName("world");
        a=foo;
    }

    private static void modifyReference(Foo b){
       b.setName("world");
    }
}
