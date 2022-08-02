package com.record.srcode.dto;

import com.google.common.base.Converter;
import com.record.srcode.po.EmissionBoard;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author lifez
 * @Date 2022/8/2
 */
@Data
public class EmissionBoardDTO implements Serializable {
    private static final long serialVersionUID = -9147989036178418750L;

    /**
     *
     */
    private Integer id;

    /**
     *
     */
    private Integer modelId;

    /**
     *
     */
    private Integer trackId;

    private String modelName;

    private String trackName;

    /**
     * 增量值
     */
    private Double computeValue;

    /**
     * 累计值
     */
    private Double cumulativeValue;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private Date createTime;

    public EmissionBoard convertToEmissionBoard() {
        EmissionBoardDTOConvert emissionBoardDTOConvert = new EmissionBoardDTOConvert();
        return emissionBoardDTOConvert.doForward(this);
    }

    public EmissionBoardDTO convertFor(EmissionBoard emissionBoard) {
        EmissionBoardDTOConvert emissionBoardDTOConvert = new EmissionBoardDTOConvert();
        return emissionBoardDTOConvert.doBackward(emissionBoard);
    }


    private class EmissionBoardDTOConvert extends Converter<EmissionBoardDTO, EmissionBoard> {

        @Override
        protected EmissionBoard doForward(EmissionBoardDTO s) {
            EmissionBoard emissionBoard = new EmissionBoard();
            BeanUtils.copyProperties(s, emissionBoard);
            return emissionBoard;
        }

        @Override
        protected EmissionBoardDTO doBackward(EmissionBoard t) {
            EmissionBoardDTO emissionBoardDTO = new EmissionBoardDTO();
            BeanUtils.copyProperties(t, emissionBoardDTO);
            return emissionBoardDTO;
        }
    }
}
