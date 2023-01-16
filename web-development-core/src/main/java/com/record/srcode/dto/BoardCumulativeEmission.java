package com.record.srcode.dto;

import lombok.Data;

/**
 * @Author Ryan
 * @Date 2022/7/27
 */
@Data
public class BoardCumulativeEmission {
    private long trackId;
    private long emissionSourceId;
    private Double computeValue;
}
