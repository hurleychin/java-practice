package com.evil.clone.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Person implements  Cloneable{
    private String name;
    private Integer age;
    private List<Son> sons;



    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person) super.clone();
        List<Son> list = new ArrayList<>();
        for (Son son : sons) {
            Object cloned = son.clone();
            list.add((Son) cloned);
        }
        clone.sons = list;
        return clone;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Person{");
        sb.append("name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", sons=").append(sons);
        sb.append('}');
        return sb.toString();
    }
}
