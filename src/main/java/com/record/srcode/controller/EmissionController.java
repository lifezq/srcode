package com.record.srcode.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.record.srcode.bo.Response;
import com.record.srcode.dto.EmissionBoardDTO;
import com.record.srcode.exception.TestException;
import com.record.srcode.po.EmissionBoard;
import com.record.srcode.service.EmissionBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Ryan
 * @Date 2022/7/27
 */
@RestController
@RequestMapping(value = "/emission")
public class EmissionController {
    @Autowired
    private EmissionBoardService emissionBoardService;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/resetTrackId", method = RequestMethod.GET)
    public Response resetTrackId(@RequestParam Integer from, @RequestParam Integer to) throws TestException {
        emissionBoardService.updateTransaction(from, to);
        return Response.builder().returnCode(200).returnMsg("update transaction data").returnUserMsg("ok").build();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Response edit(EmissionBoardDTO emissionBoardDTO) {
        UpdateWrapper<EmissionBoard> updateWrapper = new UpdateWrapper<>();
        updateWrapper.setEntity(emissionBoardDTO.convertToEmissionBoard());
        emissionBoardService.update(updateWrapper);
        return Response.builder().returnCode(200).returnMsg("edit transaction data").returnUserMsg("ok").build();
    }
}
