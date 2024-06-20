package com.diit.auth.handler;

import com.diit.common.base.response.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *@description: 统一异常处理类
 *@author:     yujunxin
 *@createTime: 2024/6/20 9:18
 *@version:    1.0
 */
@RestControllerAdvice
@Slf4j
@Order(-1)
public class AuthExceptionHandler {

    /**
     * 用户不存在
     * @param e
     * @return APIResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(UsernameNotFoundException.class)
    public APIResponse handleUsernameNotFoundException(UsernameNotFoundException e) {
        log.error("用户不存在", e);
        return new APIResponse(HttpStatus.BAD_REQUEST.value(), "用户不存在");
    }

    /**　
     * 用户账号密码异常
     * @param e　
     * @return　APIResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidGrantException.class)
    public APIResponse handleInvalidGrantException(InvalidGrantException e) {
        log.error("用户名或密码错误", e);
        return new APIResponse(HttpStatus.BAD_REQUEST.value(), "用户名或密码错误");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidClientException.class)
    public APIResponse handleInvalidClientException(InvalidClientException e) {
        log.error("账号异常", e);
        return new APIResponse(HttpStatus.BAD_REQUEST.value(),"账号异常");
    }

    /**
     * 参数校验异常
     * @param e
     * @return APIResponse
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public APIResponse handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("参数错误", e);
        return new APIResponse(HttpStatus.BAD_REQUEST.value(), "参数错误");
    }

    /**
     *  系统异常
     * @param e
     * @return APIResponse
     */
     @ResponseStatus(HttpStatus.BAD_REQUEST)
     @ExceptionHandler(Exception.class)
     public APIResponse handleException(Exception e) {
         log.error("系统异常", e);
         return new APIResponse(HttpStatus.BAD_REQUEST.value(), "系统异常");
     }

}
