package com.record.srcode.dto;

import lombok.Data;

/**
 * @Author Ryan
 * @Date 2022/7/27
 */
@Data
public class BoardTimeTrend {
    private long trackId;
    private String ym;
    private Double computeValue;
}
