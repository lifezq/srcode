package com.bean.life.beanDefinition.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Package com.bean.life.beanDefinition.config
 * @ClassName BeanFactoryPostProcessorTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
@ComponentScan(value = {"com.bean.life.beanDefinition.bo", "com.bean.life.beanDefinition.service"})
@Configuration
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("BeanFactoryPostProcessor.postProcessBeanFactory 扩展方法--可进行修改beanDefinition的定义信息");
    }
}
