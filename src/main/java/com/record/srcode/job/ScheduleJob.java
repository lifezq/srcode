package com.record.srcode.job;


import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import com.record.srcode.po.EmissionBoard;
import com.record.srcode.service.EmissionBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleJob {
    @Autowired
    EmissionBoardService emissionBoardService;

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

    @Scheduled(fixedDelay = 1000000)
    public void s3() {
        EmissionBoard emissionBoard = emissionBoardService.findById(2);
        System.out.println(emissionBoard);

        emissionBoard = emissionBoardService.boradOne(2);
        System.out.println(emissionBoard);

        String beginTime = "2022-07-01 00:00:03";
        String endTime = "2022-07-18 23:59:59";

        List<BoardTimeTrend> boardTimeTrend = emissionBoardService.boardTimeTrend(beginTime, endTime);
        boardTimeTrend.forEach(x -> System.out.printf("%s \n", x));

        List<BoardCumulativeEmission> boardCumulativeEmission = emissionBoardService.
                boardCumulativeEmission(beginTime, endTime);
        boardCumulativeEmission.forEach(x -> System.out.printf("%s \n", x));
    }
}
