package com.diit.common.web.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取调用方的来源
 * 在服务A调用服务B的时候要让服务B知道调用它服务的是服务A
 * @author yjxbz
 */
@Component
public class RequestOriginParserDefinition implements RequestOriginParser {
    // 获取调用方标识信息并返回，实际上要在请求的请求头里塞入调用方信息
    @Override
    public String parseOrigin(HttpServletRequest request) {
        String serviceName = request.getHeader("serviceName");
        StringBuffer url = request.getRequestURL();
        if (url.toString().endsWith("favicon.ico")) {
            // 浏览器会向后台请求favicon.ico图标
            return serviceName;
        }
 
        if (StringUtils.isEmpty(serviceName)) {
            // 如果服务名为空 中止调用
            throw new IllegalArgumentException("serviceName must not be null");
        }
 
        return serviceName;
    }
}