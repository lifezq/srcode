package com.spring.proxy;

import java.lang.annotation.*;

/**
 * @Package com.spring.proxy
 * @ClassName TestMethod
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestMethod {
}
