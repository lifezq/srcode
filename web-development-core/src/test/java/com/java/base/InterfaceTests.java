package com.java.base;

import com.java.base.interfacer.InterfaceTest;
import com.java.base.interfacer.InterfaceTestExpand;
import org.junit.jupiter.api.Test;

/**
 * @Package com.java.base
 * @ClassName InterfacerTests
 * @Description an interface can extend another interface,
 * once the class implements the extended interface, it must
 * implement all the methods in which super and extend interfaces.
 * @Author lifez
 * @Date 2022/8/6
 */
public class InterfaceTests implements InterfaceTestExpand {
    @Override
    public String topMethod() {
        return "top method...";
    }

    @Override
    public String interfaceExpandMethod() {
        return "interface expend method";
    }

    @Test
    public void testInterface() {
        System.out.println(value);
        System.out.println(this.defaultMethod());
        System.out.println(this.topMethod());
        System.out.println(InterfaceTest.staticMethod());
        System.out.println(this.interfaceExpandMethod());
    }
}
