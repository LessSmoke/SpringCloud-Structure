package com.diit.admin.starter.feign;

import com.diit.common.base.response.APIResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yjxbz
 */
@FeignClient(value = "diit-admin")
public interface UserFeignClient {

    @GetMapping("/api/v1/users/username/{username}")
    APIResponse getUserByUsername(@PathVariable String username);
}