package com.spring.async;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Package com.spring.async
 * @ClassName AsyncTestConfig
 * @Description TODO
 * @Author Ryan
 * @Date 2022/8/15
 */
@EnableAsync
@EnableScheduling
@ComponentScan(basePackages = {"com.record.srcode"})
@MapperScan(basePackages = {"com.record.srcode.mapper"})
@Configuration
public class AsyncTestConfig {
}
