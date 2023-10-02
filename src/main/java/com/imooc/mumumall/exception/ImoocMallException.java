package com.imooc.mumumall.exception;

public class ImoocMallException extends Exception{
    private final Integer code;
    private final String message;

    public ImoocMallException(Integer code, String msg) {
        this.code = code;
        this.message = msg;
    }

    public ImoocMallException(ImoocMallExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
