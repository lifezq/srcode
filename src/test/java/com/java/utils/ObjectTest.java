package com.java.utils;

import org.junit.jupiter.api.Test;

/**
 * @Author Ryan
 * @Date 2022/8/4
 */
public class ObjectTest {

    @Test
    public void testObjectNotify() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            // 通过调用synchronized使当前线程持有该对象的monitor
            synchronized (lock) {//A thread becomes the owner of the object's monitor
                System.out.println("t1 is running, and wait lock...");
                try {
                    lock.wait();
                    System.out.println("t1 after wait...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 is running, and will release t1.lock...");
                System.out.println("t2 sleep 3s");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notify();
                System.out.println("t2 after notify");
            }
        });
        t2.start();

        Thread.sleep(5000);
    }

    @Test
    public void testObjectNotifyAll() throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {
            // 通过调用synchronized使当前线程持有该对象的monitor
            synchronized (lock) {//A thread becomes the owner of the object's monitor
                System.out.println("t1 is running, and wait lock...");
                try {
                    lock.wait();
                    System.out.println("t1 after wait...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t2 is running, and wait lock...");
                try {
                    lock.wait();
                    System.out.println("t2 after wait...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();

        Thread t3 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("t3 is running, and will release Object.lock...");
                System.out.println("t3 sleep 3s");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lock.notifyAll();
                System.out.println("t3 after notify all");
            }
        });
        t3.start();

        Thread.sleep(5000);
    }
}
