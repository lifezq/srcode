package com.java.classloader;

import org.junit.jupiter.api.Test;

/**
 * @Package com.java.classloader
 * @ClassName ClassLoaderTest
 * @Description 双亲委派机制
 * @Author Ryan
 * @Date 2022/8/9
 */
public class ClassLoaderTest {
    @Test
    public void testString() {
        // 自己无法定义与系统同包路径同名的类覆盖系统类
        String s = new String();
        s.setData(111);
        s.setNumber(22.2F);
        System.out.println(s);
    }
}
