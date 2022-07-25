package com.spring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut(value = "execution(public * com.record.srcode.controller..*.*(..))")
    public void aopDemo() {
    }

    @Pointcut(value = "@annotation(com.record.srcode.log.ControllerWebLog)")
    public void webLog() {
    }
}
