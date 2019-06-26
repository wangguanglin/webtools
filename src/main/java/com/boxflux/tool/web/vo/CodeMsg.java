package com.boxflux.tool.web.vo;

/**
 * Created by wangguanglin on 2019/6/11.
 */
public enum CodeMsg {
    ACCESS_LIMIT_REACHED(8888,"操作太频繁，请慢点！");

    private int code;

    private String msg;

    CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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


}
