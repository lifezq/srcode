package com.record.srcode.entry.impl;

import com.record.srcode.entry.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Override
    public void use() {
        System.out.println("使用动物<狗>看门");
    }
}
