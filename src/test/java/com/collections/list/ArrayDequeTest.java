package com.collections.list;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * ● add和remove是一对，源自Collection；
 * ● offer和poll是一对，源自Queue；
 * ● push和pop是一对，源自Deque，其本质是栈（Stack类由于某些历史原因，官方已不建议使用，使用Deque代替）；
 * ● offerFirst/offerLast和pollFirst/pollLast是一对，源自Deque，其本质是双端队列。
 *
 * @Author Ryan
 * @Date 2022/7/27
 */
public class ArrayDequeTest {
    @Test
    public void testArrayDeque() {
        Deque<String> deque = new ArrayDeque<String>(1);
        deque.push("a");
        deque.push("b");
        deque.push("c");
        deque.push("d");

        deque.offerLast("e");
        deque.offerLast("f");
        deque.offerLast("g");
        deque.offerLast("h"); // 这时候扩容了
        deque.push("i");
        deque.offerLast("j");
        System.out.println("数据出栈：");
        while (!deque.isEmpty()) {
            System.out.print(deque.pop() + " ");
        }
    }
}
