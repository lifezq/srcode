package com.thread.sequence.sync;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Package com.thread.sequence.sync
 * @ClassName ThreadSequenceSynchronous
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/10
 */
public class ThreadSequenceSynchronous {
    @SneakyThrows
    @Test
    public void testSequenceSynchronous() {
        MyThreadSequenceSynchronous myThreadSequenceSynchronous = new MyThreadSequenceSynchronous();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceSynchronous.printA();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceSynchronous.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                myThreadSequenceSynchronous.printC();
            }
        }, "C").start();

        Thread.sleep(1000);
    }

    class MyThreadSequenceSynchronous {
        private int flag = 1;
        private Logger log = LogManager.getLogger(MyThreadSequenceSynchronous.class);

        public synchronized void printA() {
            while (flag != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = 2;
            this.notifyAll();
            log.info("Thread[{}] {}", Thread.currentThread().getName(), "A");
        }

        public synchronized void printB() {
            while (flag != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = 3;
            this.notifyAll();
            log.info("Thread[{}] {}", Thread.currentThread().getName(), "B");
        }

        public synchronized void printC() {
            while (flag != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            flag = 1;
            this.notifyAll();
            log.info("Thread[{}] {}", Thread.currentThread().getName(), "C");
        }
    }
}
