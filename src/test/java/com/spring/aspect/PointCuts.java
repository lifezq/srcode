package com.spring.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    @Pointcut(value = "execution(public * com.aspect.controller..*.*(..))")
    public void aopDemo() {
    }

    @Pointcut(value = "@annotation(com.aspect.log.ControllerWebLog)")
    public void webLog() {
    }
}
