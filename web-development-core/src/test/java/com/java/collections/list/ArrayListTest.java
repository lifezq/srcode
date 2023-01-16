package com.java.collections.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description default capacity is 10
 * capacity increased by 50%
 * @Author Ryan
 * @Date 2022/7/26
 */
public class ArrayListTest {

    @Test
    public void testArrayList() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        System.out.println("通过数组转换： " + (list1.toArray().getClass() == Object[].class));

        // jdk9 后修复了该Bug
        // defend against c.toArray (incorrectly) not returning Object[]
        // (see e.g. https://bugs.openjdk.java.net/browse/JDK-6260652)
        ArrayList<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        System.out.println("通过集合转换： " + (list2.toArray().getClass() == Object[].class));
    }

    @Test
    public void testNcopies() {
        ArrayList<Integer> list = new ArrayList<Integer>(Collections.nCopies(10, 0));
        list.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println("");
    }
}
