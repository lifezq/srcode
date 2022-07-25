package com.record.srcode.exception;


import com.record.srcode.bo.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler(TestException.class)
    public Response handleException(TestException testException) {
        Response result = new Response();
        result.setReturnCode(100000);
        result.setReturnMsg("MyExceptionHandler。" + testException.getMessage());
        System.out.println("----------------" + result);
//        return "MyExceptionHandler." + testException.getMessage();
        return result;
    }
}
