package com.spring.async;

import com.record.srcode.config.AppConfig;
import com.record.srcode.job.ScheduleJob;
import com.record.srcode.service.AsyncTestService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;


public class AsyncTest {

    @Test
    public void asyncTest() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        AsyncTestService u = ctx.getBean(AsyncTestService.class);
        for (Integer i = 0; i < 10; i++) {
            u.executeAsync1(i);
            u.executeAsync2(i);
        }
        ctx.close();
    }

    @Test
    public void scheduleTest() {
        System.out.println("schedule..." + new Date());

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        ScheduleJob u = ctx.getBean(ScheduleJob.class);
        try {
            Thread.sleep(50000000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}
