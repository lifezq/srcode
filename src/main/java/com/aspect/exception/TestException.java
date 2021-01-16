package com.aspect.exception;

public class TestException extends Exception {
    //异常信息
    private String message;

    //构造函数
    public TestException(String message) {
        super(message);
        this.message = message;
    }

    //获取异常信息,由于构造函数调用了super(message),不用重写此方法
    //public String getMessage(){
    //    return message;
    //}
}
