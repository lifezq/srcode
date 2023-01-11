package com.java.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Package com.java.utils
 * @ClassName IteratorTests
 * @Description TODO
 * @Author Ryan
 * @Date 2023/1/11
 */
public class IteratorTests {

    @Test
    public void testIterator() {
        List<String> list = Arrays.asList("hello", "world", "!");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println("next:" + next);
        }
    }
}
