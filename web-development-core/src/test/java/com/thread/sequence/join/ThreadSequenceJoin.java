package com.thread.sequence.join;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Package com.thread.sequence.join
 * @ClassName ThreadSequenceJoin
 * @Description 线程ABC, 打印ABC
 * @Author lifez
 * @Date 2022/6/10
 */
public class ThreadSequenceJoin {
    private Logger log = LogManager.getLogger(ThreadSequenceJoin.class);

    @SneakyThrows
    @Test
    public void testJoin() {
        Thread t1 = new Thread(() -> log.info("Thread:{}", Thread.currentThread().getName()), "A");
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Thread:{}", Thread.currentThread().getName());
        }, "B");
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Thread:{}", Thread.currentThread().getName());
        }, "C");

        t1.start();
        t2.start();
        t3.start();

        Thread.sleep(200);
    }

    @SneakyThrows
    @Test
    public void testJoin1() {
        Thread t1 = new Thread(() -> log.info("Thread:{}", Thread.currentThread().getName()), "A");
        Thread t2 = new Thread(() -> log.info("Thread:{}", Thread.currentThread().getName()), "B");
        Thread t3 = new Thread(() -> log.info("Thread:{}", Thread.currentThread().getName()), "C");

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

        Thread.sleep(200);
    }
}
