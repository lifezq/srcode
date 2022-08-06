package com.java.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * @Package com.java.map
 * @ClassName HashmapTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
public class MapTest {
    @Test
    public void testHashmap() {
        HashMap<String, String> m = new HashMap<>();
        m.put(null, "null value");
        System.out.println(m.get(null));
    }

    @Test
    public void testHashTable() {
        // hashTable 是线程安全的， put/get都是同步方法
        Hashtable<String, String> hashtable = new Hashtable<>();
//        hashtable.put(null, "null value");// throw: NullPointerException
        hashtable.put("ok", "ok value");
        System.out.println(hashtable.get("ok"));
    }
}
