package com.evil.reflection;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class Person implements IPerson {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void eat(String food) {
        System.out.println(name + " is eatting " +food);
    }

    @Override
    public float sleep(float time) {
        System.out.println(name+" is sleeping! Time:"+time+ " h");
        return time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
