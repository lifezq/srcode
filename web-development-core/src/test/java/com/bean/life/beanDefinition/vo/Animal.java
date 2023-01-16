package com.bean.life.beanDefinition.vo;

import lombok.Data;

/**
 * @Package com.bean.life.beanDefinition.vo
 * @ClassName Ainimal
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/18
 */
@Data
public class Animal {
    private String name;


    public void initAnimal() {
        System.out.println("init-method 动物bean初始化方法---init-method");
    }

    public void destroyAnimal() {
        System.out.println("destroy-method 动物bean销毁方法---destroy-method");
    }
}
