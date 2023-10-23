package com.evil.threadsafe;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Service
//@Scope(SCOPE_PROTOTYPE) @Autowire fail，ApplicationContext.getBean() pass
public class CounterService {

    /**
     * volatile fail
     * ThreadLocal pass
     */
//    private int count;
    private ThreadLocal<Integer> countLocal=ThreadLocal.withInitial(() -> 0);

    /**
     *  synchronized  fail
     */
    public  int increment(int incrementsPerThread) {
        for(int i=1;i<=incrementsPerThread;i++){
//            count+=i;
            Integer count = countLocal.get();
            countLocal.set(count+i);
            System.out.println(Thread.currentThread().getName() + " is running:" + countLocal.get() );
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return countLocal.get();
    }



    public static void main(String[] args) {
        CounterService counterService=new CounterService();
        System.out.println(counterService.increment(100));
    }

}