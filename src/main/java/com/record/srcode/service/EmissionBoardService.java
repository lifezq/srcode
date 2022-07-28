package com.record.srcode.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import com.record.srcode.exception.TestException;
import com.record.srcode.po.EmissionBoard;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lenovo
 * @description 针对表【emission_board(排放看板表)】的数据库操作Service
 * @createDate 2022-07-27 18:22:19
 */
public interface EmissionBoardService extends IService<EmissionBoard> {
    EmissionBoard findById(long id);

    EmissionBoard boradOne(@Param("id") long id);

    List<BoardTimeTrend> boardTimeTrend(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<BoardCumulativeEmission> boardCumulativeEmission(@Param("beginTime") String beginTime,
                                                          @Param("endTime") String endTime);

    void updateTransaction(@Param("from") long from, @Param("to") long to) throws TestException;
}
