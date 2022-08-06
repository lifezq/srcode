package com.java.base;

import com.java.base.interfacer.InterfaceTest;
import org.junit.jupiter.api.Test;

/**
 * @Package com.java.base
 * @ClassName InterfacerTests
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class InterfaceTests implements InterfaceTest {
    @Override
    public String topMethod() {
        return "top method...";
    }

    @Test
    public void testInterface() {
        System.out.println(value);
        System.out.println(this.defaultMethod());
        System.out.println(this.topMethod());
        System.out.println(InterfaceTest.staticMethod());
    }
}
