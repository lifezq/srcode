package com.aspect.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
@Aspect
public class Aspect2 {

    @Before(value = "com.aspect.test.PointCuts.aopDemo()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect2] before advise");
    }

    @Around(value = "com.aspect.test.PointCuts.aopDemo()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Aspect2] around advise 1");
        pjp.proceed();
        System.out.println("[Aspect2] around advise2");
    }

    @AfterReturning(value = "com.aspect.test.PointCuts.aopDemo()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterReturning advise");
    }

    @AfterThrowing(value = "com.aspect.test.PointCuts.aopDemo()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterThrowing advise");
    }

    @After(value = "com.aspect.test.PointCuts.aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect2] after advise");
    }
}
