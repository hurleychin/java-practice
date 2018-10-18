package com.evil.spring.context;

import com.evil.spring.aop.aspectj.FooService;
import com.evil.spring.aop.xml.IBar;
import com.evil.util.Console;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author qinhu
 * @date 2018-09-23
 */
@Configuration
@ComponentScan(basePackages = {"com.evil.spring.*.*"})
public class ApplicationContextSample implements ApplicationContextAware {

    public final static int ANNOTATION_CONFIG=0;
    public final static int XML_CONFIG=1;

    static ConfigurableApplicationContext ctx;
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
//        Console.out(getBeanByAnnotationConfig("getUser"));
//        Console.out(getBeanByAnnotationConfig(ApplicationContextSample.class));
//      getBeanByAnnotationConfig(TransactionManagerSample.class).testTransactionDefinition();
//        getBeanByAnnotationConfig(FooService.class).execute(1);
//      Console.out("Application call result:"+getBeanByAnnotationConfig(FooService.class).execute("hello"));
        Console.out(getBeanByXmlConfig(IBar.class,"bar").sayHello("Evil"));

//        ctx.close();

    }


    private static  <T> T getBeanByAnnotationConfig(Class<T> c,Object... o){

        return getApplicationContext(ANNOTATION_CONFIG).getBean(c,o);
    }

    private static  <T> T getBeanByAnnotationConfig(String s){

        return (T) getApplicationContext(ANNOTATION_CONFIG).getBean(s);
    }

    private static <T> T getBeanByXmlConfig(Class<T> c,String s){
        return  getApplicationContext(XML_CONFIG).getBean(s,c);
    }


    private static ApplicationContext getApplicationContext(int configType){
        synchronized (ApplicationContextSample.class){
           if(null==ctx){
               if(configType==ANNOTATION_CONFIG){
                   ctx=new AnnotationConfigApplicationContext(ApplicationContextSample.class);

//                   Console.out("ApplicationContext refreshing...");
//                   ctx.refresh();
               }else {
                   ctx=new ClassPathXmlApplicationContext("spring/applicationContext.xml");
               }
           }
        }
        Console.out("ApplicationContext ready!");
        return ctx;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
       Console.out(applicationContext);
    }
}
