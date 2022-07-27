package generator.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.record.srcode.dto.BoardCumulativeEmission;
import com.record.srcode.dto.BoardTimeTrend;
import generator.po.BoardCarbonEmission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author Ryan
 * @description 针对表【board_carbon_emission(碳排放看板表)】的数据库操作Mapper
 * @createDate 2022-07-27 14:22:54
 * @Entity generator.emission.BoardCarbonEmission
 */
@Mapper
public interface BoardCarbonEmissionMapper extends BaseMapper<BoardCarbonEmission> {
    @Select("SELECT * from board_carbon_emission where id=#{id}")
    BoardCarbonEmission findById(@Param("id") long id);

    BoardCarbonEmission boradOne(@Param("id") long id);

    @Select("SELECT t1.track_id, DATE_FORMAT(t1.create_time,\"%Y-%m\") AS ym, SUM(t1.compute_value) AS compute_value " +
            " FROM board_carbon_emission AS t1  " +
            " LEFT JOIN cb_carbon_track AS t2 ON t1.track_id=t2.id  " +
            " LEFT JOIN cb_data_model AS t3 ON t1.model_id=t3.id  " +
            " LEFT JOIN cb_emission_source AS t4 ON t1.emission_source_id=t4.id  " +
            " WHERE t1.create_time>#{beginTime} AND t1.create_time<#{endTime} AND t2.state=1 AND t3.id>0 AND t4.id>0 " +
            " GROUP BY t1.track_id,ym;")
    List<BoardTimeTrend> boardTimeTrend(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    List<BoardCumulativeEmission> boardCumulativeEmission(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

    int updateEmissionByTrackId(@Param("from") long from, @Param("to") long to);

    int updateTrackByTrackId(@Param("from") long from, @Param("to") long to);
}




