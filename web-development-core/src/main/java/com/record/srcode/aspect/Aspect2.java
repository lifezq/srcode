package com.record.srcode.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
@Aspect
public class Aspect2 {

    @Before(value = "com.record.srcode.aspect.PointCuts.aopDemo()")
    public void before(JoinPoint joinPoint) {
        System.out.println("[Aspect2] before advise");
    }

    @Around(value = "com.record.srcode.aspect.PointCuts.aopDemo()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[Aspect2] around advise 1");
        Object ret = pjp.proceed();
        System.out.println("[Aspect2] around advise2");
        return ret;
    }

    @AfterReturning(value = "com.record.srcode.aspect.PointCuts.aopDemo()")
    public void afterReturning(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterReturning advise");
    }

    @AfterThrowing(value = "com.record.srcode.aspect.PointCuts.aopDemo()")
    public void afterThrowing(JoinPoint joinPoint) {
        System.out.println("[Aspect2] afterThrowing advise");
    }

    @After(value = "com.record.srcode.aspect.PointCuts.aopDemo()")
    public void after(JoinPoint joinPoint) {
        System.out.println("[Aspect2] after advise");
    }
}
