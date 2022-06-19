package com.bean.life.beanDefinition;

import com.bean.life.beanDefinition.bo.Person;
import com.bean.life.beanDefinition.config.MyBeanFactoryPostProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.bean.life.beanDefinition
 * @ClassName BeanDefinitionTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
public class BeanDefinitionTest {
    private final Logger log = LogManager.getLogger(BeanDefinitionTest.class);

    @Test
    public void testBeanDefinition() {
        Lock lock = new ReentrantLock();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyBeanFactoryPostProcessor.class);
        Person person = applicationContext.getBean(Person.class);
        person.setName("name string");
        person.setAge(22);
        log.info("bean person {}", person);
        applicationContext.close();
    }
}
