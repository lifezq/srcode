package com.record.srcode.controller;


import com.record.srcode.bo.Response;
import com.record.srcode.exception.TestException;
import com.record.srcode.log.ControllerWebLog;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/aop")
public class AopTestController {

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ControllerWebLog(name = "接口日志 POST 请求测试", intoDb = false)
    public Response test(@RequestParam boolean throwException) throws TestException {
        // case 1
        if (throwException) {
            System.out.println("throw an exception");
            throw new TestException("mock a server exception");
        }

        // case 2
        System.out.println("test OK");
        return Response.builder().returnCode(200).returnMsg("mock a Result").returnUserMsg("ok").build();
    }
}