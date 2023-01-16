package com.record.srcode.entity.impl;

import com.record.srcode.entity.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
@Primary
public class Cat implements Animal {

    @Override
    public void use() {
        System.out.println("使用动物<猫>捉老鼠");
    }
}
