package com.evil.spring.aop.xml;


import com.evil.util.Console;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author qinhu
 * @date 2018-10-09
 */
public class BarAspect {
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        long startTime=System.currentTimeMillis();
       result = joinPoint.proceed();
        long endTime=System.currentTimeMillis();
        Console.out("Bar method call use "+(endTime-startTime)+" ms ,args: "+joinPoint.getArgs()[0]);
        return  result;
    }
}
