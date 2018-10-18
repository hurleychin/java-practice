package com.evil.spring.context;

import com.evil.util.Console;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * @author qinhu
 * @date 2018-09-23
 */
//@Component
//@Scope("prototype")
//@Lazy
public class User implements InitializingBean, DisposableBean, Lifecycle {

    private Integer id;
    private String name;
    private int age;
    private String sex="UNKOWN";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User@"+this.hashCode()+"{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
//   we suggest using the @PostConstruct annotation or specifying a POJO initialization method.
    @Override
    public void afterPropertiesSet() throws Exception {
        Console.out("afterPropertiesSet");
    }
// we suggest using the @PreDestroy annotation or specifying a generic method that is supported by bean definitions.
    @Override
    public void destroy() throws Exception {
        Console.out("destroy");
    }

    @Override
    public void start() {
        Console.out("start");

    }

    @Override
    public void stop() {
        Console.out("stop");

    }

    @Override
    public boolean isRunning() {
        return false;
    }

    public void init(){
       Console.out("init");
    }
    public void cleanup(){
        Console.out("cleanup");
    }

}
