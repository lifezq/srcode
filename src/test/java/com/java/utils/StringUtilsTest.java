package com.java.utils;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @Package com.java
 * @ClassName StringUtilsTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/7/31
 */
public class StringUtilsTest {
    @Test
    public void testEmpty() {
        System.out.println(" ".isEmpty()); // false
        System.out.println(" ".isBlank()); // true
        System.out.println(" ".length()); // 1

        System.out.println(StringUtils.isEmpty(" "));//false
        System.out.println(StringUtils.isBlank(" "));//true
    }
}
