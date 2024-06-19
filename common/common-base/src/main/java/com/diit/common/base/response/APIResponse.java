package com.diit.common.base.response;

import com.diit.common.base.exception.ToolCenterException;
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

    public APIResponse(IResponseCode responseCode, String msg) {
        this.code = responseCode.getCode();
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
        this(responseCode);
        this.trace = msg;
        this.data = data;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode, Long count, Object data) {
        this(responseCode);
        this.data = data;
        this.count = count;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(IResponseCode responseCode, String msg, long count, Object data) {
        this(responseCode);
        this.trace = msg;
        this.count = count;
        this.data = data;
        this.timestamp = (new Date()).getTime();
    }

    public APIResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public APIResponse fail(){
        return new APIResponse(403,"参数校验异常");
    }
}
