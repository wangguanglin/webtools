package com.boxflux.tool.web.vo;

/**
 * Created by wangguanglin on 2019/6/11.
 */

public class Result<T> {

    private Integer code;

    private String msg;

    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Result success(T data){
        this.code = 0;
        this.msg = "success";
        this.data = data;
        return this;
    }

    public Result fail(CodeMsg codeMsg){
        this.msg = codeMsg.getMsg();
        this.code = codeMsg.getCode();
        this.data = null;
        return this;
    }
}
