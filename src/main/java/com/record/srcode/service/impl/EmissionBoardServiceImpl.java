package com.record.srcode.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import com.record.srcode.exception.TestException;
import com.record.srcode.mapper.EmissionBoardMapper;
import com.record.srcode.po.EmissionBoard;
import com.record.srcode.service.EmissionBoardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lenovo
 * @description 针对表【emission_board(排放看板表)】的数据库操作Service实现
 * @createDate 2022-07-27 18:22:19
 */
@Service
public class EmissionBoardServiceImpl extends ServiceImpl<EmissionBoardMapper, EmissionBoard>
        implements EmissionBoardService {

    @Override
    public EmissionBoard findById(long id) {
        return this.getBaseMapper().findById(id);
    }

    @Override
    public EmissionBoard boradOne(@Param("id") long id) {
        return this.getBaseMapper().boradOne(id);
    }


    @Override
    public List<BoardTimeTrend> boardTimeTrend(String beginTime, String endTime) {
        return this.getBaseMapper().boardTimeTrend(beginTime, endTime);
    }

    @Override
    public List<BoardCumulativeEmission> boardCumulativeEmission(
            @Param("beginTime") String beginTime, @Param("endTime") String endTime) {
        return this.getBaseMapper().boardCumulativeEmission(beginTime, endTime);
    }


    @Transactional
    @Override
    public void updateTransaction(@Param("from") long from, @Param("to") long to) throws TestException {

        try {

            int nums = this.getBaseMapper().updateEmissionByTrackId(from, to);
            if (nums < 1) {
                throw new TestException("1.事务执行失败");
            }

            System.out.println("1.事务更新影响条数：" + nums);

            nums = this.getBaseMapper().updateTrackByTrackId(from, to);
            if (nums < 1) {
                throw new TestException("2.事务执行失败");
            }

            System.out.println("2.事务更新影响条数：" + nums);

            // 测试事务
//            throw new RuntimeException("事务强制抛出异常");
        } catch (Exception e) {
            throw new TestException(e.getMessage());
        }
    }
}




