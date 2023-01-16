package com.thread.threadlocal;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.core.NamedThreadLocal;

/**
 * @Package com.thread.threadlocal
 * @ClassName ThreadLocalTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/12
 */
public class ThreadLocalTest {
    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();
    private final ThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
    private final ThreadLocal<String> namedThreadLocal = new NamedThreadLocal<>("named thread local");
    private final Logger log = LogManager.getLogger(ThreadLocalTest.class);

    @SneakyThrows
    @Test
    public void testThreadLocal() {
        threadLocal.set("thread local main:value");
        new Thread(() -> {
            threadLocal.set("thread local 1:value");
            for (int i = 0; i < 10; i++) {
                log.info("Thread[{}] threadLocal.get:{}", Thread.currentThread().getName(), threadLocal.get());
            }
        }, "T-A").start();

        new Thread(() -> {
            threadLocal.set("thread local 2:value");
            for (int i = 0; i < 10; i++) {
                log.info("Thread[{}] threadLocal.get:{}", Thread.currentThread().getName(), threadLocal.get());
            }
        }, "T-B").start();

        log.info("Thread[{}] threadLocal.get:{}", Thread.currentThread().getName(), threadLocal.get());

        Thread.sleep(1000);
    }

    @SneakyThrows
    @Test
    public void testInheritableThreadLocal() {
        inheritableThreadLocal.set("inheritable thread local 1:value");
        new Thread(() -> {
            log.info("Thread[{}] inheritableThreadLocal.get:{}", Thread.currentThread().getName(), inheritableThreadLocal.get());
        }).start();

        Thread.sleep(200);
    }

    @Test
    public void testNamedThreadLocal() {
        namedThreadLocal.set("named thread local 1:value");
        log.info("Thread[{}] namedThreadLocal[{}].get:{}", Thread.currentThread().getName(), namedThreadLocal.toString(), namedThreadLocal.get());
    }
}
