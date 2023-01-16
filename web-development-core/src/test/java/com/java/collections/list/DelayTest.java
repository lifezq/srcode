package com.java.collections.list;

import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author Ryan
 * @Date 2022/7/28
 */
@Getter
public class DelayTest {
    private static final Logger log = LogManager.getLogger(DelayTest.class);

    @Test
    public void testDelayed() throws InterruptedException {
        DelayQueue<DelayTestObject> delayQueue = new DelayQueue<>();
        delayQueue.offer(new DelayTestObject());
        delayQueue.offer(new DelayTestObject(5, 5, TimeUnit.SECONDS));
        delayQueue.offer(new DelayTestObject(10, 10, TimeUnit.SECONDS));

        log.info(delayQueue.take().data);
        log.info(delayQueue.take().data);
        log.info(delayQueue.take().data);
    }


    class DelayTestObject implements Delayed {

        public int data;
        public long delayTime;


        DelayTestObject() {
            this.data = -1;
            this.delayTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(3);
        }

        DelayTestObject(int data, long time, TimeUnit unit) {
            this.data = data;
            this.delayTime = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
        }

        @Override
        public long getDelay(@NotNull TimeUnit unit) {
            return delayTime - System.currentTimeMillis();
        }

        @Override
        public int compareTo(@NotNull Delayed o) {
            DelayTestObject delayTest = (DelayTestObject) o;
            if (this.delayTime - delayTest.delayTime <= 0) {
                return -1;
            }
            return 1;
        }
    }
}
