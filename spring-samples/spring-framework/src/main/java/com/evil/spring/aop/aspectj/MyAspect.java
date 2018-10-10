package com.evil.spring.aop.aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author qinhu
 * @date 2018-10-08
 */
@Aspect
@Component
@Order
public class MyAspect implements Ordered {

    @Before("execution(* FooService.execute(..))")
    public void before (JoinPoint joinPoint) {
        System.out.println("MyAspect.before ()");
        aspectjLogging( joinPoint);
    }

    @AfterReturning(value = "execution(* FooService.execute(..))",returning = "retVal")
    public void afterReturning (Object retVal) {
        System.out.println("MyAspect.afterReturning (),return val:"+retVal );
    }

    @AfterThrowing(value="execution(* FooService.execute(..))",throwing = "ex")
    public void afterThrowing (JoinPoint joinPoint,Throwable ex) throws Exception{
        System.out.println("MyAspect.afterThrowing (),throwing:"+ex);
        aspectjLogging( joinPoint);
    }

    @After("execution( String FooService.execute(..))")
    public void after (JoinPoint joinPoint)//finally
    {
        System.out.println("MyAspect.after ()");
        aspectjLogging( joinPoint);
    }

    @Around("execution( String FooService.execute(..))")
    public Object around (ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("MyAspect.around ()");
        return joinPoint.proceed();
//        aspectjLogging( joinPoint);
    }

    private synchronized void aspectjLogging(JoinPoint joinPoint){
        System.err.println("entering: " + joinPoint);
        System.err.println("  w/args: " + joinPoint.getArgs());
        System.err.println("      at: " + joinPoint.getSourceLocation());
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
