package com.diit.common.web.exception;

import com.diit.common.base.response.IResponseCode;

public enum ResponseCode implements IResponseCode {

    FAIL("403", "失败");

    private String msg;

    private String code;

    ResponseCode(String msg, String code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public int getCode() {
        return 0;
    }

    @Override
    public String getMsg() {
        return null;
    }
}
