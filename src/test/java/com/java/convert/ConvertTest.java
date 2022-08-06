package com.java.convert;

import com.record.srcode.convert.EmissionBoardMapper;
import com.record.srcode.dto.EmissionBoardDTO;
import com.record.srcode.po.EmissionBoard;
import org.junit.jupiter.api.Test;

/**
 * @Package com.java.convert
 * @ClassName ConvertTest
 * @Description 少用或不用BeanUtils.copyPropertys， 相反使用convert替代
 * @Author lifez
 * @Date 2022/8/6
 */
public class ConvertTest {

    @Test
    public void testMapStruct() {
        EmissionBoard emissionBoard = new EmissionBoard().setId(11).
                setComputeValue(88.8).setCumulativeValue(101.26).
                setModelId(87).setTrackId(99);
        EmissionBoardDTO emissionBoardDTO = EmissionBoardMapper.INSTANCE.toEmissionBoardDTO(emissionBoard);
        System.out.println(emissionBoardDTO);
    }
}
