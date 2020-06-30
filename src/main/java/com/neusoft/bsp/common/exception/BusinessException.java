package com.neusoft.bsp.common.exception;

public class BusinessException extends RuntimeException{
    public static final BusinessException USERNAME_NOT_EXISTS = new BusinessException(504,"user doesn't exist",new Object[0]);
    public static final BusinessException PASSWORD_WRONG = new BusinessException(504,"password is wrong",new Object[0]);

    int code;
    String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public BusinessException(){}
    public BusinessException(int code, String msg, Object... args){
        super(String.format(msg,args));
        this.code = code;
        this.msg = String.format(msg,args);
    }
    public BusinessException (String message){
        super(message);
    }
}
