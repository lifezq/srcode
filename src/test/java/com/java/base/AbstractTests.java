package com.java.base;

import com.java.base.abstractor.AbstractorTest;
import com.java.base.interfacer.InterfaceTest;
import org.junit.jupiter.api.Test;

/**
 * @Package com.java.base
 * @ClassName AbstractTests
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class AbstractTests extends AbstractorTest implements InterfaceTest {

    @Override
    public String topMethod() {
        return "abstract";
    }

    @Test
    public void testAbstract() {
        System.out.println(value);
        System.out.println(getName());
        System.out.println(topMethod());
        System.out.println(secondMethod());
    }
}
