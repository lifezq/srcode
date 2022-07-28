package com.java.collections.list;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

/**
 * @Desc 所有队列不能添加null元素，队列为空时返回null. Blocking Queue 线程安全
 * Queue LinkedBlockingQueue    由双端链表结构组成的有界阻塞队列
 * Queue ArrayBlockingQueue     由数组结构组成的有界阻塞队列
 * Queue PriorityBlockingQueue  由数组结构组成支持优先级排序的无界阻塞队列
 * Queue SynchronousQueue       不存储元素的阻塞队列
 * Queue LinkedTransferQueue    由单向链表结构组成的无界阻塞队列
 * Deque LinkedBlockingDeque    由链表结构组成的双向阻塞队列
 * Deque ConcurrentLinkedDeque  由链表结构组成的线程安全的双向阻塞队列
 * @Author Ryan
 * @Date 2022/7/28
 */
public class QueueTest {
    @Test
    public void testArrayBlockingQueue() {
        // 有容量限制
        // 底层实现：数组
        // ReentrantLock
        ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<>(1);
        q.offer(1);// return true;
        q.offer(2);// return false;

        System.out.println(q.poll());// output:1
        System.out.println(q.poll());// output:null

        q.add(1);// return true
//        q.add(2);// throw IllegalStateException: Queue full
        System.out.println(q.remove());// output:1
        System.out.println(q.remove());// throw NoSuchElementException
    }

    @Test
    public void testLinkedBlockingQueue() {
        // 有容量限制
        // 底层实现：双端链表
        // ReentrantLock
        // 默认无界队列，即无限长   capacity=Integer.MAX_VALUE
        LinkedBlockingQueue<Integer> q = new LinkedBlockingQueue<>(1);
        q.offer(1);// return true;
        q.offer(2);// return false;

        System.out.println(q.poll());// output:1
        System.out.println(q.poll());// output:null

        q.add(1);// return true
        q.add(2);// throw IllegalStateException: Queue full
        System.out.println(q.remove());// output:1
        System.out.println(q.remove());// throw NoSuchElementException
    }

    @Test
    public void testPriorityBlockingQueue() {
        // 底层实现：数组
        // ReentrantLock
        // default capacity=11 ，容量不够时，自动扩容
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : (o1.equals(o2) ? 0 : -1);
            }
        };
        PriorityBlockingQueue<Integer> q = new PriorityBlockingQueue<>(1, comparator);
        q.offer(1);// return true;
        q.offer(2);// return true; //容量不够时，自动扩容

        System.out.println(q.poll());// output:2
        System.out.println(q.poll());// output:1

        q.add(1);// return true
        q.add(2);// return true
        System.out.println(q.remove());// output:2
        System.out.println(q.remove());// output:1
    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        //同步队列，没有容量。
        //必须两个线程一个存，一个取，一个存一个取....
        CountDownLatch countDownLatch = new CountDownLatch(2);
        SynchronousQueue<Integer> q = new SynchronousQueue<>();
        Thread t1 = new Thread() {
            @SneakyThrows
            public void run() {
                for (int i = 0; i < 10; i++) {
                    q.put(i);
                    System.out.println("添加元素：" + i);
                }
                countDownLatch.countDown();
            }
        };
        t1.start();


        Thread t2 = new Thread() {
            @SneakyThrows
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("出队元素：" + q.take());
                }
                countDownLatch.countDown();
            }
        };
        t2.start();

        countDownLatch.await();
    }

    @Test
    public void testLinkedTransferQueue() {
        // 无容量限制
        //单向链表，  无界阻塞队列
        LinkedTransferQueue<Integer> q = new LinkedTransferQueue<>();
        q.offer(1);// return true;
        q.offer(2);// return true;

        System.out.println(q.poll());// output:1
        System.out.println(q.poll());// output:2

        q.add(1);// return true
        q.add(2);// return true
        System.out.println(q.remove());// output:1
        System.out.println(q.remove());// output:2
    }

    @Test
    public void testLinkedBlockingDeque() {
        // 有容量限制
        //ReentrantLock
        // default capacity=integer.MAX_VALUE, 默认无界队列
        // 双向链表阻塞队列
        LinkedBlockingDeque<Integer> q = new LinkedBlockingDeque<>(1);
        q.offer(1);// return true;
        q.offer(2);// return false;

        System.out.println(q.poll());// output:1
        System.out.println(q.poll());// output:null

        q.add(1);// return true
//        q.add(2);// throw IllegalStateException: Deque full
        System.out.println(q.remove());// output:1
        System.out.println(q.remove());// throw NoSuchElementException
    }

    @Test
    public void testConcurrentLinkedDeque() {
        // 无容量限制
        // 双端链表 无界队列
        ConcurrentLinkedDeque<Integer> q = new ConcurrentLinkedDeque<>();
        q.offer(1);// return true;
        q.offer(2);// return true;

        System.out.println(q.poll());// output:1
        System.out.println(q.poll());// output:2

        q.add(1);// return true
        q.add(2);// return true
        System.out.println(q.remove());// output:1
        System.out.println(q.remove());// output:2
    }
}
