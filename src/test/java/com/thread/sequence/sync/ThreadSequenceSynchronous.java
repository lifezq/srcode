package com.thread.sequence.sync;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

/**
 * @Package com.thread.sequence.sync
 * @ClassName ThreadSequenceSynchronous
 * @Description synchronized是Java中的关键字，被Java原生支持，是一种最基本的同步锁。
 * 它修饰的对象有以下几种：
 * 　　1. 修饰一个代码块，被修饰的代码块称为同步语句块，其作用的范围是大括号{}括起来的代码，作用的对象是调用这个代码块的对象。
 * 　　2. 修饰一个方法，被修饰的方法称为同步方法，其作用的范围是整个方法，作用的对象是调用这个方法的对象。
 * 　　3. 修改一个静态的方法，其作用的范围是整个静态方法，作用的对象是这个类的所有对象。
 * 　　4. 修改一个类，其作用的范围是synchronized后面括号括起来的部分，作用主的对象是这个类的所有对象。
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
