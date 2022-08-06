package com.record.srcode.convert;

import com.record.srcode.dto.EmissionBoardDTO;
import com.record.srcode.po.EmissionBoard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @Package com.record.srcode.convert
 * @ClassName EmissionBoardMapper
 * @Description TODO
 * @Author lifez
 * @Date 2022/8/6
 */
@Mapper
public interface EmissionBoardConvertor {
    EmissionBoardConvertor INSTANCE = Mappers.getMapper(EmissionBoardConvertor.class);

    @Mappings(value = {
            @Mapping(target = "modelName", expression = "java(\"模型名称1\")"),
            @Mapping(target = "trackName", expression = "java(\"足迹名称1\")")
    })
    EmissionBoardDTO toEmissionBoardDTO(EmissionBoard emissionBoard);
}
