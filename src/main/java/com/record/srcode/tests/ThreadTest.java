package com.record.srcode.tests;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author yangqianlei
 * @date 2021/1/16
 * @description ThreadTest
 */
public class ThreadTest {
    private HashMap<String, String> hm = new HashMap<>();
    private static Logger log = Logger.getLogger("ThreadTest");

    @Test
    public void startTest() {
        log.info("befor thread run...");
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception " + e);
            }

        }).start();
        log.info("after thread run...");
    }

    @Test
    public void callTest() {

        try {
            log.info("befor thread run...");
            ConcurrentTaskExecutor concurrentTaskExecutor = new ConcurrentTaskExecutor();
            Future<Integer> v = concurrentTaskExecutor.submit(new CallTest());
            log.info("after thread run...");

            while (!v.isDone()) {
                Thread.sleep(100);
            }
            System.out.println("call response " + v.get());
        } catch (Exception e) {
            System.out.println("Call Exception " + e);
        }
    }

    /**
     * 线程池创建,四种：
     * 1. newCachedThreadPool: 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程
     * 2. newFixedThreadPool: 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待
     * 3. newScheduledThreadPool: 创建一个定长线程池，支持定时及周期性任务执行
     * 4. newSingleThreadExecutor: 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
     */
    @Test
    public void threadPool0Test() {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            Future<Integer> r = executorService.submit(new CallTest());
            Collection<Callable<Integer>> callables = new ArrayList<>();
            callables.add(new CallTest());
            callables.add(new CallTest());
            callables.add(new CallTest());
            executorService.invokeAll(callables);
            System.out.println("返回" + r.get());
        } catch (Exception e) {
            System.out.println("threadPool0Test 异常" + e);
        }
    }

    @Test
    public void threadPool1Test() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<Integer> r = executorService.submit(new CallTest());
            Collection<Callable<Integer>> callables = new ArrayList<>();
            callables.add(new CallTest());
            callables.add(new CallTest());
            callables.add(new CallTest());
            executorService.invokeAll(callables);
            System.out.println("返回" + r.get());
        } catch (Exception e) {
            System.out.println("threadPool1Test 异常" + e);
        }
    }

    @Test
    public void threadPool2Test() {
        try {
            ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
            log.info("befor schedule exe...");
            ScheduledFuture<Integer> r = executorService.schedule(new CallTest(), 3, TimeUnit.SECONDS);
            log.info("after schedule exe...");
            Collection<Callable<Integer>> callables = new ArrayList<>();
            callables.add(new CallTest());
            callables.add(new CallTest());
            callables.add(new CallTest());
            executorService.invokeAll(callables);
            System.out.println("返回" + r.get());
        } catch (Exception e) {
            System.out.println("threadPool2Test 异常" + e);
        }
    }

    @Test
    public void threadPool3Test() {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Collection<Callable<Integer>> callables = new ArrayList<>();
            callables.add(new CallTest());
            callables.add(new CallTest());
            callables.add(new CallTest());
            List<Future<Integer>> r = executorService.invokeAll(callables);
            for (Future<Integer> v : r) {
                System.out.println("返回" + v.get());
            }
        } catch (Exception e) {
            System.out.println("threadPool3Test 异常" + e);
        }
    }

    @Test
    public void concurrentThreadTest() {
        try {
            ExecutorService executorService = Executors.newFixedThreadPool(4);
            ConcurrentCallTest concurrentCallTest = new ConcurrentCallTest();
            Future<Integer> r = executorService.submit(concurrentCallTest);
            Collection<Callable<Integer>> callables = new ArrayList<>();
            callables.add(concurrentCallTest);
            callables.add(concurrentCallTest);
            callables.add(concurrentCallTest);
            executorService.invokeAll(callables);
            System.out.println("返回" + r.get());
            executorService.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.out.println("concurrentThreadTest 异常" + e);
        }
    }

    public class CallTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            try {
                log.log(Level.INFO, "线程[{0}] Callable call exec...\n", Thread.currentThread().getId());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Exception " + e);
            }
            return 11;
        }
    }

    public class ConcurrentCallTest implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            String key = "";
            try {
                long threadID = Thread.currentThread().getId();

                for (int i = 1; i < 100; i++) {
                    key = threadID + "." + i;
                    hm.put(key, key);
                    if (hm.get(key) != key) {
                        System.out.printf("map set key:%s error,want[%s], got[%s]\n", key, i, hm.get(key));
                    }
                }

                Random random = new Random();
                Iterator<Map.Entry<String, String>> iter = hm.entrySet().iterator();
                while (iter.hasNext()) {
                    Map.Entry<String, String> item = iter.next();
                    if (random.nextInt(100) == 0) {
                        System.out.printf("HashMap key:%s value:%s\n", item.getKey(), item.getValue());
                    }
                }

                log.log(Level.INFO, "线程[{0}] Callable call exec...\n", Thread.currentThread().getId());
                Thread.sleep(5000);
            } catch (ConcurrentModificationException e) {
                System.out.println("并发读写map ConcurrentModificationException " + e);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException " + e);
            } catch (NullPointerException e) {
                System.out.println("NullPointerException key:" + key + " e:" + e);
            }
            return 11;
        }
    }
}
