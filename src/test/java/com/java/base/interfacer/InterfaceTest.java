package com.java.base.interfacer;

/**
 * @Package com.java.base.interfacer
 * @ClassName InterfaceTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public interface InterfaceTest {
    public static final String value = "ok";

    public abstract String topMethod();

    public default String defaultMethod() {
        return "default";
    }
}
