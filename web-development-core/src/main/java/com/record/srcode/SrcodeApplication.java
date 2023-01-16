package com.record.srcode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EnableAsync
@EnableScheduling
@EnableWebSecurity
//Note: has enabled the transaction manager by default because of springboot. org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.
//@EnableTransactionManagement
@MapperScan(basePackages = {"com.record.srcode.mapper"})
@SpringBootApplication
public class SrcodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SrcodeApplication.class, args);
    }
}
