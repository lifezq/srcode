package com.spring.proxy;

import com.spring.proxy.config.ProxyBpp1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Package com.spring.proxy
 * @ClassName ProxyTest
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/25
 */
@ComponentScan(basePackages = "com.spring.proxy")
@SpringBootTest(classes = {BppTestBean.class, BppTestDepBean.class, ProxyBpp1.class})
public class ProxyTest {
    @Autowired
    private BppTestBean bppTestBean;

    @Test
    public void test() {
        bppTestBean.test1();
        bppTestBean.test2();
        bppTestBean.test3();
    }
}
