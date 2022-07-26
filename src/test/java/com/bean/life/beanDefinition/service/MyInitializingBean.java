package com.bean.life.beanDefinition.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @Package com.bean.life.beanDefinition.service
 * @ClassName MyInitialzingBean
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
@Component
public class MyInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        // 一个 InitializingBean 执行一次
        // spring 初始化方法，作用是在BeanFactory完成属性设置之后,执行自定义的  初始化行为.
        // 执行顺序：在initMethod之前执行，在@PostConstruct之后执行
        System.out.println("InitializingBean.afterPropertiesSet");
    }
}
