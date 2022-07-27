package generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import com.record.srcode.exception.TestException;
import generator.po.BoardCarbonEmission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Ryan
 * @description 针对表【board_carbon_emission(碳排放看板表)】的数据库操作Service
 * @createDate 2022-07-27 14:22:54
 */
public interface BoardCarbonEmissionService extends IService<BoardCarbonEmission> {
    BoardCarbonEmission findById(long id);

    BoardCarbonEmission boradOne(@Param("id") long id);

    List<BoardTimeTrend> boardTimeTrend(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<BoardCumulativeEmission> boardCumulativeEmission(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    void updateTransaction(@Param("from") long from, @Param("to") long to) throws TestException;
}
