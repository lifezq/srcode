package com.thread.cyclicBarrier;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Package com.thread.cyclicBarrier
 * @ClassName CyclicBarrierTest
 * @Description TODO
 * @Author lifez
 * @Date 2022/6/11
 */
public class CyclicBarrierTest {
    @SneakyThrows
    @Test
    public void testCyclicBarrier() {
        int N = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new SoldierBarrier(N));
        CyclicBarrierSoldierTask cyclicBarrierSoldierTask = new CyclicBarrierSoldierTask(cyclicBarrier);
        for (int i = 0; i < N; i++) {
            new Thread(cyclicBarrierSoldierTask).start();
        }

        Thread.sleep(1000);
    }

    class SoldierBarrier implements Runnable {
        private boolean flag;
        private int N;
        private Logger log = LogManager.getLogger(SoldierBarrier.class);

        SoldierBarrier(int N) {
            this.N = N;
        }

        @Override
        public void run() {
            if (this.flag) {
                this.flag = false;
                log.info("Soldier[{}] 任务完成！", this.N);
            } else {
                log.info("Soldier[{}] 集结完毕！", this.N);
                this.flag = true;
            }
        }
    }

    class CyclicBarrierSoldierTask implements Runnable {
        private CyclicBarrier cyclicBarrier;
        private Logger log = LogManager.getLogger(CyclicBarrierSoldierTask.class);

        CyclicBarrierSoldierTask(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }


        @Override
        public void run() {
            try {
                log.info("CyclicBarrierSoldierTask[{}] wait...", Thread.currentThread().getName());
                this.cyclicBarrier.await();

                log.info("CyclicBarrierSoldierTask[{}] do work...", Thread.currentThread().getName());
                this.doWork();

                log.info("CyclicBarrierSoldierTask[{}] wait work be completed...", Thread.currentThread().getName());
                this.cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            log.info("CyclicBarrierSoldierTask[{}] is working[{}]...", Thread.currentThread().getName(), this.cyclicBarrier.getNumberWaiting());
        }
    }
}
