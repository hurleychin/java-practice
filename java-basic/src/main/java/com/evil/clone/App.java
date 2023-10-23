package com.evil.clone;

import com.evil.clone.bean.Person;
import com.evil.clone.bean.Son;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person=new Person();
        person.setAge(30);
        person.setName("Jack");

        List<Son> sons=new ArrayList<>();
        Son son1=new Son();
        son1.setSex("男");
        son1.setName("QHL");

        sons.add(son1);

        person.setSons(sons);

        Person person2= (Person) person.clone();
        person2.setName("Tom");
        person2.setAge(10);
        person2.getSons().get(0).setSex("女");

        System.out.println(person);
        System.out.println(person2);

    }
}
