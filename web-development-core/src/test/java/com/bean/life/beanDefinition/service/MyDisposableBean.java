package com.bean.life.beanDefinition.service;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.stereotype.Component;

/**
 * @Package com.bean.life.beanDefinition.service
 * @ClassName MyDisposableBean
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
@Component
public class MyDisposableBean implements DisposableBean {
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean.destroy 我被销毁了");
    }
}
