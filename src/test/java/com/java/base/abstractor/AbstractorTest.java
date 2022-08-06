package com.java.base.abstractor;

import lombok.Getter;

/**
 * @Package com.java.base.abstractor
 * @ClassName AbstractorTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
@Getter
public abstract class AbstractorTest {
    private String name = "default abstract";


    public abstract String topMethod();
    
    public String secondMethod() {
        return "second";
    }
}
