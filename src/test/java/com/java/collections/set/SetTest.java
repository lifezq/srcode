package com.java.collections.set;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Package com.java.collections.set
 * @ClassName SetTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class SetTest {
    @Test
    public void testSet() {
        Set<String> s = new HashSet<>();
        s.add(null);
        s.add("set data");
        for (String s1 : s) {
            System.out.println(s1);
        }
    }

    @Test
    public void testTreeSet() {
        // treeSet 不是线程安全
        TreeSet<String> treeSet = new TreeSet<>();
//        treeSet.add(null);//throw:NullPointerException
        treeSet.add("ok value");
        for (String s : treeSet) {
            System.out.println(s);
        }
    }
}
