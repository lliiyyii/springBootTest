package com.demo.entity;

public class BaseApi {
    protected String msg;
    protected int errorCode;
    protected Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseApi(String msg, int errorCode, Object data) {
        this.msg = msg;
        this.errorCode = errorCode;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

}


