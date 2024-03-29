package com.record.srcode.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.aop.interceptor.SimpleAsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AsyncConfig implements AsyncConfigurer {

    AsyncConfig() {
        System.out.println("AsyncConfig init");
    }

    @Override
    public Executor getAsyncExecutor() {
        //线程池
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();


        taskExecutor.setCorePoolSize(10); //核心线程数
        taskExecutor.setMaxPoolSize(20);  //最大线程数
        taskExecutor.setQueueCapacity(1000); //队列大小
        taskExecutor.setKeepAliveSeconds(300); //线程最大空闲时间
        taskExecutor.setThreadNamePrefix("Async-Executor-"); //指定用于新创建的线程名称的前缀。
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略（一共四种，此处省略）
        
        // 这一步千万不能忘了，否则报错： java.lang.IllegalStateException: ThreadPoolTaskExecutor not initialized
        // 初始化
        taskExecutor.initialize();

        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SimpleAsyncUncaughtExceptionHandler();
    }
}
