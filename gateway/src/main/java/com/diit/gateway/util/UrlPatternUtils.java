package com.diit.gateway.util;


import com.alibaba.cloud.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;

import java.nio.file.PathMatcher;

/**
 * @author yjxbz
 */
public class UrlPatternUtils {

    public static boolean match(String patternUrl,String requestUrl){
        if (StringUtils.isBlank(patternUrl) || StringUtils.isBlank(requestUrl)){
            return false;
        }
        AntPathMatcher matcher = new AntPathMatcher();
        return matcher.match(patternUrl,requestUrl);
    }
}
