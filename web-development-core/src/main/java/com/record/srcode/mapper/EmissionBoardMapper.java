package com.record.srcode.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import com.record.srcode.po.EmissionBoard;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author lenovo
 * @description 针对表【emission_board(排放看板表)】的数据库操作Mapper
 * @createDate 2022-07-27 18:22:19
 * @Entity com.record.srcode.po.EmissionBoard
 */
public interface EmissionBoardMapper extends BaseMapper<EmissionBoard> {
    @Select("SELECT * from emission_board where id=#{id}")
    EmissionBoard findById(@Param("id") long id);

    EmissionBoard boradOne(@Param("id") long id);

    @Select("SELECT t1.track_id, DATE_FORMAT(t1.create_time,\"%Y-%m\") AS ym, SUM(t1.compute_value) AS compute_value " +
            " FROM emission_board AS t1  " +
            " LEFT JOIN emission_track AS t2 ON t1.track_id=t2.id  " +
            " WHERE t1.create_time>#{beginTime} AND t1.create_time<#{endTime} AND t2.state=1 " +
            " GROUP BY t1.track_id,ym;")
    List<BoardTimeTrend> boardTimeTrend(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<BoardCumulativeEmission> boardCumulativeEmission(
            @Param("beginTime") String beginTime, @Param("endTime") String endTime);

    int updateEmissionByTrackId(@Param("from") long from, @Param("to") long to);

    int updateTrackByTrackId(@Param("from") long from, @Param("to") long to);

    List<EmissionBoard> listByPage(@Param("page") Page page);
}




