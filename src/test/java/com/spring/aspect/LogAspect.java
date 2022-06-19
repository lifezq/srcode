package com.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(98)
@Aspect
@Component
public class LogAspect {

    @Around(value = "com.spring.aspect.PointCuts.webLog()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[WEB日志] around advise 1");
        pjp.proceed();
        System.out.println("[WEB日志] around advise2");
    }
}
