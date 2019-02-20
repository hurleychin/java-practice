package com.evil.passbyvalue;

/** Java is always pass-by-value
 * @author qinhu
 * @date 2018-08-24
 */
public class App {
    public static void main(String[] args) {

        Foo foo=new Foo();
        foo.setName("hello");

        int i=100;

        passByReference(foo,i);
        System.out.println("after passByReference:"+ foo.toString()+"\n"+i);
        passByValue(foo,i);
        System.out.println("after modifyReference:"+ foo.toString()+"\n"+i);

    }

    private static void passByReference(Foo a,int i){
       a=null;
       i=-1;
    }

    private static void passByValue(Foo b,int i){
       b.setName("world");
       i=-1;
    }
}
