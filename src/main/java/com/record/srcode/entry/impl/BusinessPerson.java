package com.record.srcode.entry.impl;

import com.record.srcode.entry.Animal;
import com.record.srcode.entry.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class BusinessPerson implements Person {
    @Autowired
    @Qualifier("bird")
    Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
