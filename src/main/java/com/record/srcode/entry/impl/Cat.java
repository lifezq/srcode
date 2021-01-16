package com.record.srcode.entry.impl;

import com.record.srcode.entry.Animal;
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
