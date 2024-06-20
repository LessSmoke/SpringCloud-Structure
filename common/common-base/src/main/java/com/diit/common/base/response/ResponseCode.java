package com.diit.common.base.response;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum ResponseCode implements IResponseCode{
    SUCCESS("000000", "成功"),
    SYSTEM_EXECUTION_ERROR("999999", "系统执行出错"),
    USERNAME_OR_PASSWORD_ERROR("A00100", "用户名或密码错误"),
    USER_NOT_EXIST("A00101", "用户不存在"),
    CLIENT_AUTHENTICATION_FAILED("A00212", "客户端认证失败"),
    ACCESS_UNAUTHORIZED("A00213", "未授权"),
    TOKEN_INVALID_OR_EXPIRED("A00214", "token非法或失效"),
    TOKEN_ACCESS_FORBIDDEN("A00215", "token禁止访问"),
    FLOW_LIMITING("B0210", "系统限流"),
    DEGRADATION("B0220", "系统功能降级"),
    SERVICE_NO_AUTHORITY("B0221", "服务未授权"),
    ;

    private String code;

    private String msg;

    @Override
    public String toString() {
        return "{" +
                "\"code\":\"" + code + '\"' +
                ", \"msg\":\"" + msg + '\"' +
                '}';
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
