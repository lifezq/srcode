package com.thread.countDownLatch;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

/**
 * @Package com.thread.countDownLatch
 * @ClassName CountDownLatch
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/10
 */
public class CountDownLatchTest {

    @SneakyThrows
    @Test
    public void testCountDownLatch() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        MyCountDownLatchThread myCountDownLatchThread1 = new MyCountDownLatchThread(countDownLatch, "Thread-A");
        MyCountDownLatchThread myCountDownLatchThread2 = new MyCountDownLatchThread(countDownLatch, "Thread-B");

        MyCountDownLatchWorker myCountDownLatchWorker1 = new MyCountDownLatchWorker(countDownLatch, "Worker-A");
        MyCountDownLatchWorker myCountDownLatchWorker2 = new MyCountDownLatchWorker(countDownLatch, "Worker-B");
        MyCountDownLatchWorker myCountDownLatchWorker3 = new MyCountDownLatchWorker(countDownLatch, "Worker-C");

        myCountDownLatchThread1.start();
        myCountDownLatchThread2.start();

        Thread.sleep(1000);

        myCountDownLatchWorker1.start();
        myCountDownLatchWorker2.start();
        myCountDownLatchWorker3.start();

        Thread.sleep(200);
    }

    class MyCountDownLatchThread extends Thread {
        private CountDownLatch countDownLatch;
        private Logger log = LogManager.getLogger(MyCountDownLatchThread.class);

        MyCountDownLatchThread(CountDownLatch countDownLatch, String name) {
            this.setName(name);
            this.countDownLatch = countDownLatch;
        }

        @SneakyThrows
        @Override
        public void run() {
            log.info("Thread[{}] begin...", Thread.currentThread().getName());
            this.countDownLatch.await();
            log.info("Thread[{}] after wait and running now...", Thread.currentThread().getName());
        }
    }

    class MyCountDownLatchWorker extends Thread {
        private CountDownLatch countDownLatch;
        private Logger log = LogManager.getLogger(MyCountDownLatchWorker.class);

        MyCountDownLatchWorker(CountDownLatch countDownLatch, String name) {
            this.setName(name);
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            this.countDownLatch.countDown();
            log.info("Worker[{}] do work...", Thread.currentThread().getName());
        }
    }
}
