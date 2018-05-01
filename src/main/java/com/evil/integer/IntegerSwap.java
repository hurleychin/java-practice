package com.evil.integer;

public class IntegerSwap {
    public static void main(String[] args){
       Integer a=1,b=2;
       System.out.println("befor: a="+a+",b="+b);
       swap(a,b);
       System.out.println("after: a="+a+",b="+b);
    }

    public static void swap(Integer i,Integer j){
        Integer temp=i;
        i=j;
        j=temp;
    }
}
