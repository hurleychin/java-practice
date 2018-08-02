package com.evil.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author qinhu
 * @date 2018/6/21
 */
public class ReflectionTest {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.evil.reflection.Person");
           Constructor constructor= aClass.getConstructor(String.class, int.class);
           //通过反射初始化实例
           IPerson person= (Person) constructor.newInstance("evil",20);

           //通过反射hack字段值
           Field field=aClass.getDeclaredField("age");
           //私有字段需要强制访问权限,否则会跑出异常
            field.setAccessible(true);
           field.setInt(person,field.getInt(person)+10);
            System.out.println(person);

            //通过反射hack方法
            Method method=aClass.getMethod("sleep",float.class);
            float time=(float)method.invoke(person,5.5f);
            method.invoke(person,time+10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
