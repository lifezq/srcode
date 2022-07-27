package com.record.srcode.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(98)
@Aspect
@Component
public class LogAspect {

    @Around(value = "com.record.srcode.aspect.PointCuts.webLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("[WEB日志] around advise 1");
        Object ret = pjp.proceed();
        System.out.println("[WEB日志] around advise2");
        return ret;
    }
}
