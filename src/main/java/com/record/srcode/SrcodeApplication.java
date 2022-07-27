package com.record.srcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAsync
@EnableScheduling
@EnableTransactionManagement
@MapperScan(basePackages = {"generator.mapper"})
@ComponentScan(basePackages = {"com.record.srcode.*", "generator.*"})
@SpringBootApplication
public class SrcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrcodeApplication.class, args);
    }
}
