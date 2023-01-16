package com.spring.proxy;

import org.springframework.stereotype.Component;

/**
 * @Package com.spring.proxy
 * @ClassName BppTestDepBean
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/25
 */
@Component
public class BppTestDepBean {
    public void testDep() {
        System.out.println("HEHE");
    }
}
