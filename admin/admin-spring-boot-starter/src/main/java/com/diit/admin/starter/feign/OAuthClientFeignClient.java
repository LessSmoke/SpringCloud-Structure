package com.diit.admin.starter.feign;

import com.diit.common.base.response.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 获取客户端信息的feign
 * @author yjxbz
 */
@FeignClient(value = "diit-admin", contextId = "oauth-client")
public interface OAuthClientFeignClient {

    @GetMapping("/api/oauth-clients/getOAuth2ClientById")
    APIResponse getOAuth2ClientById(@RequestParam String clientId);
}