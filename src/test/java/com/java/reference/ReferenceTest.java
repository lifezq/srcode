package com.java.reference;

import com.java.reference.bo.User;
import org.junit.jupiter.api.Test;

import java.lang.ref.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Java （基本数据类型）值传递 和 （数组、类、接口、字符串）共享对象传递（引用传递）
 *
 * @Desc 强引用
 * @Author Ryan
 * @Date 2022/7/28
 */
public class ReferenceTest {
    @Test
    public void testHardReference() {
        int data = 0;
        setData(data);
        System.out.println(data);

        Integer data1 = 1000;
        setData(data1);
        System.out.println(data1);

        User user = new User();
        user.setName("joy");
        user.setAge(18);
        System.out.println(user.toString() + System.identityHashCode(user));
        setUser(user);
    }

    @Test
    public void testSoftReference() {
        User user = new User();
        user.setName("joy");
        user.setAge(22);

        //当内存不足时，会回收SoftReference
        SoftReference<User> softReference = new SoftReference<>(user);
        System.out.println(softReference.get());
    }

    @Test
    public void testWeakReference() {
        User user = new User();
        user.setName("joy");
        user.setAge(22);

        //弱引用指向的对象如果没有强引用指向，GC 时就会回收弱引用指向的对象
        WeakReference<User> weakReference = new WeakReference<>(user);
        user = null;
        System.gc();
        System.out.println(weakReference.get());
    }

    @Test
    public void testPhantomReference() throws InterruptedException {
        OOMObject oomObject = new OOMObject();

        //虚引用：顾名思义，就是形同虚设，与其他几种引用都不同，虚引用并不会决定对象的生命周期。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收器回收。虚引用主要用来跟踪对象被垃圾回收的活动。虚引用与软引用和弱引用的一个区别在于：虚引用必须和引用队列（ReferenceQueue）联合使用。
        ReferenceQueue<OOMObject> referenceQueue = new ReferenceQueue<>();
        PhantomReference<OOMObject> phantomReference = new PhantomReference<>(oomObject, referenceQueue);
        System.out.println(phantomReference.get()); // output:null
        System.out.println(referenceQueue.poll()); // output:null

        List<String> list = new ArrayList<>();

        Thread t1 = new Thread() {
            public void run() {

                for (int i = 0; i < 1000000; i++) {
                    list.add("123");
                    System.out.println("-" + list.size() + "---" + phantomReference.get());
                }
            }
        };

        t1.start();

        while (true) {
            Reference<? extends OOMObject> pollReference = referenceQueue.poll();
            if (pollReference != null) {
                System.out.println("虚引用对象被回收了，回收对象：" + pollReference.get());
                t1.interrupt();
                return;
            }
        }
    }

    public void setData(int data) {
        data = 10;
    }

    public void setData(Integer data) {
        data = 2000;
    }

    public void setUser(User user) {
        user.setName("joy111");
        System.out.println(System.identityHashCode(user));
    }

    @Test
    public void printMemoryAddress() {
        String s1 = "hello";
        String s2 = "world";
        String s3 = "helloworld";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);
        System.out.println(s3.hashCode());
        System.out.println(s4.hashCode());
        //System.identityHashCode(Object)方法可以返回对象的内存地址,不管该对象的类是否重写了hashCode()方法
        System.out.println(System.identityHashCode(s3));
        System.out.println(System.identityHashCode(s4));
    }


    class OOMObject {
        private final long[] data = new long[1024 * 1024];
    }
}
