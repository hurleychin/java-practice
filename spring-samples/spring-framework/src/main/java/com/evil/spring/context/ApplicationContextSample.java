package com.evil.spring.context;

import com.evil.spring.jdbc.tx.TransactionManagerSample;
import com.evil.util.Console;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.*;

/**
 * @author qinhu
 * @date 2018-09-23
 */
@Configuration
@ComponentScan(basePackages = "com.evil.spring.*.*")
public class ApplicationContextSample implements ApplicationContextAware {

    public final static String basePackages="com.evil.spring.*";

    static  AnnotationConfigApplicationContext ctx;
//
//    @Autowired
//    private  User user;

//    public ApplicationContextSample(@Required User user){
//        this.user=user;
//    }

    @Bean(initMethod = "init",destroyMethod = "cleanup")
    public User getUser(){
        return new User();
    }

    public static void main(String[] args) throws Exception {
//        User u=getBeanByAnnotationConfig(User.class);
//        u.setName("evil");
//
//        Console.out(u);
        Console.out(getBeanByAnnotationConfig("getUser"));
        Console.out(getBeanByAnnotationConfig(ApplicationContextSample.class));
        getBeanByAnnotationConfig(TransactionManagerSample.class).testTransactionDefinition();

//        ctx.close();

    }

    private static  <T> T getBeanByAnnotationConfig(Class<T> c,Object... o){

        return getApplicationContext().getBean(c,o);
    }

    private static  <T> T getBeanByAnnotationConfig(String s){

        return (T) getApplicationContext().getBean(s);
    }

    private static ApplicationContext getApplicationContext(){
        synchronized (ApplicationContextSample.class){
           if(null==ctx){
               ctx=new AnnotationConfigApplicationContext();
               ctx.register(ApplicationContextSample.class);

               Console.out("ApplicationContext refreshing...");
               ctx.refresh();
               Console.out("ApplicationContext ready!");
           }
        }
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       Console.out(applicationContext);
    }
}
