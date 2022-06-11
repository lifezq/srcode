package com.thread.semaphore;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;

/**
 * @Package com.thread.semaphore
 * @ClassName SemaphoreTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/11
 */
public class SemaphoreTest {
    @SneakyThrows
    @Test
    public void testSemaphore() {
        MySemaphore mySemaphore = new MySemaphore();
        for (int i = 0; i < 10; i++) {
            new Thread(mySemaphore).start();
        }

        Thread.sleep(1000);
    }

    class MySemaphore implements Runnable {
        private Semaphore semaphore = new Semaphore(2);
        private Logger log = LogManager.getLogger(MySemaphore.class);


        @Override
        public void run() {
            try {
                semaphore.acquire();
                log.info("Thread[{}] got acquire", Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                log.info("Thread[{}] released acquire", Thread.currentThread().getName());
            }
        }
    }
}
