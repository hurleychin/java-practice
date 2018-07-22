package com.evil.tostring;

/**
 * @author qinhu
 * @date 2017-12-27
 */
public class Dog {
    private int age;
    private String name;

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args){
//        System.out.println(new Dog());
//        System.out.println(StringUtils.leftPad(""+Calendar.getInstance().get(Calendar.DAY_OF_MONTH),2,"0") );
        System.out.println(ClassLoader.getSystemResource(""));

    }
}
