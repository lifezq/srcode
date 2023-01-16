package com.record.srcode.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncTestService {

    @Async
    public void executeAsync1(Integer i) {
        System.out.println(Thread.currentThread().getName() + "异步输出1:" + i);
    }

    @Async
    public void executeAsync2(Integer i) {
        System.out.println(Thread.currentThread().getName() + "异步输出2:" + i);
    }
}
