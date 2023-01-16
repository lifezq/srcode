package com.thread.sequence.lock;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Package com.thread.sequence.lock
 * @ClassName ThreadSequenceLock
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/10
 */
public class ThreadSequenceLock {
    @SneakyThrows
    @Test
    public void testSequenceLock() {
        MyThreadSequenceLock myThreadSequenceLock = new MyThreadSequenceLock();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceLock.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceLock.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceLock.printC();
            }
        }, "C").start();

        Thread.sleep(1000);
    }

    class MyThreadSequenceLock {
        private int flag = 1;
        private Lock lock = new ReentrantLock();
        private Condition conditionA = lock.newCondition();
        private Condition conditionB = lock.newCondition();
        private Condition conditionC = lock.newCondition();
        private Logger log = LogManager.getLogger(MyThreadSequenceLock.class);

        public void printA() {
            lock.lock();
            try {
                if (flag != 1) {
                    conditionA.await();
                }
                log.info("Thread[{}] {}", Thread.currentThread().getName(), "A");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = 2;
            conditionB.signal();
            lock.unlock();
        }

        public void printB() {
            lock.lock();
            try {
                if (flag != 2) {
                    conditionB.await();
                }
                log.info("Thread[{}] {}", Thread.currentThread().getName(), "B");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = 3;
            conditionC.signal();
            lock.unlock();
        }

        public void printC() {
            lock.lock();
            try {
                if (flag != 3) {
                    conditionC.await();
                }
                log.info("Thread[{}] {}", Thread.currentThread().getName(), "C");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = 1;
            conditionA.signal();
            lock.unlock();
        }
    }
}
