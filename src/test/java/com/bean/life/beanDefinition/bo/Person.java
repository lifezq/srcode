package com.bean.life.beanDefinition.bo;

import com.bean.life.beanDefinition.vo.Animal;
import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Package com.bean.life.beanDefinition.bo
 * @ClassName Person
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
@Data
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Component
public class Person {
    private String name;
    private Integer age;

    /**
     * 被@PostConstruct修饰的方法会在构造函数之后，init()方法之前运行。如果有多个则会执行多次
     * 注意： 如果spring 实现了 BeanPostProcessor接口的postProcessBeforeInitialization方法，该@PostConstruct注解会失效
     */
    @PostConstruct
    public void init() {
        System.out.println("PostConstruct 第一个init...");
    }

    // 有多个会执行多次
    @PostConstruct
    public void init1() {
        System.out.println("PostConstruct 第二个init1...");
    }

    @Bean(initMethod = "initAnimal", destroyMethod = "destroyAnimal")
    public Animal getAnimal() {
        return new Animal();
    }
}
