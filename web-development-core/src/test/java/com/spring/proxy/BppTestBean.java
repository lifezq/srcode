package com.spring.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Package com.spring.proxy
 * @ClassName BppTestBean
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/25
 */
@Component
public class BppTestBean {
    @Autowired
    private BppTestDepBean depBean;

    public void test1() {
        depBean.testDep();
    }

    public void test2() {
        depBean.testDep();
    }

    @TestMethod
    public void test3() {
        depBean.testDep();
    }
}