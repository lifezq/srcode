package com.record.srcode.job;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleJob {
    @Scheduled(fixedDelay = 5000)
    public void s0() {
        System.out.println("fixedDelay 5000");
    }

    @Scheduled(fixedRate = 10000)
    public void s1() {
        System.out.println("fixedRate = 10000");
    }

    @Scheduled(cron = "1/30 01-30 1-13 ? * ? ")
    public void s2() {
        System.out.println("cron = \"1/30 01-30 1-13 ? * ? \"");
    }
}
