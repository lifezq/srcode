package com.java.base;

import org.junit.jupiter.api.Test;

/**
 * @Package com.java.base
 * @ClassName StringTests
 * @Description TODO
 * @Author Ryan
 * @Date 3/18/2023
 */
public class StringTests {
    private final int numbers = 1_000_000;

    @Test
    public void fastStringConcat() {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            sb.append("*");
        }
        long end = System.currentTimeMillis();
        System.out.printf("total use: %d ms\n", end - start);// out: total use: 11 ms
    }

    @Test
    public void slowStringConcat() {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < numbers; i++) {
            s += "*";
        }
        long end = System.currentTimeMillis();
        System.out.printf("total use: %d ms\n", end - start);// out: total use: 38374 ms
    }
}
