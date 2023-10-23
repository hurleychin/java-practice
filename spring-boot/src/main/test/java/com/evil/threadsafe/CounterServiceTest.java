package com.evil.threadsafe;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CounterServiceTest {

//    @Autowired
//    private CounterService counterService;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testThreadSafety() throws InterruptedException {
        int numThreads = 10;
        int incrementsPerThread = 100;
        int result=5050;

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new MyThread("Thread " + (i + 1), startSignal,doneSignal,()->{
                CounterService counterService = applicationContext.getBean(CounterService.class);
                Assert.assertEquals(result,counterService.increment(incrementsPerThread));

            });
            thread.start();
        }

        try {
            // 等待所有线程准备就绪
            Thread.sleep(500); // 可能需要适当的延迟以确保所有线程已经启动
            startSignal.countDown(); // 发出启动信号
            // 等待所有线程执行完毕
            doneSignal.await();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}



