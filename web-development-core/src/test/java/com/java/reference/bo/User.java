package com.java.reference.bo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Author Ryan
 * @Date 2022/7/28
 */
@Getter
@Setter
public class User implements Serializable {
    private static final long serialVersionUID = 1350586970210905369L;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "{" + this.name + " " + this.age + "}";
    }
}
