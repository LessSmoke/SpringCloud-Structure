package com.diit.common.base.response;

import lombok.Data;

import java.util.Date;

/**
 * 响应报文，统一封装类
 * @author :liph
 * @date: 2023/8/28
 */

@Data
public class APIResponse {

    private int code;

    private String msg;

    private String trace;

    private Object data;

    private long timestamp;

    private long count;

    public APIResponse() {
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode) {
        this.code = responseCode.getCode();
        this.msg = responseCode.getMsg();
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(Integer code, String msg) {
        this.msg = msg;
        this.trace = msg;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode, Object data) {
        this(responseCode);
        this.data = data;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode, String msg, Object data) {
        this.code = responseCode.getCode();
        this.trace = msg;
        this.data = data;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode, String msg, long count, Object data) {
        this.code=responseCode.getCode();
        this.trace = msg;
        this.count = count;
        this.data = data;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public APIResponse(int code, String msg, Object data) {
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public APIResponse fail(){
        return new APIResponse(403,"参数校验异常");
    }

    public static APIResponse fail(ResponseCode responseCode){
        return new APIResponse(responseCode.getCode(),responseCode.getMsg());
    }
}
