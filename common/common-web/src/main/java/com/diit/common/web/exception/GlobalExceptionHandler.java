package com.diit.common.web.exception;

import com.diit.common.base.response.APIResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yjxbz
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常拦截 一般异常
     * @param ex
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public final APIResponse handleAllExceptions(Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        return new APIResponse().fail(ex);
    }

    /**
     * 全局异常处理器
     * @param ex
     * @return APIResponse
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public APIResponse handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        log.error("非法参数异常，异常原因: {}",ex.getMessage(),ex);
        return new APIResponse(ResponseCode.MethodArgumentNotValidException,ex.getMessage());
    }
}
