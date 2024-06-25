package com.diit.admin.web.web;

import com.diit.admin.starter.dto.UserAuthDTO;
import com.diit.admin.web.service.ISysUserService;
import com.diit.common.base.response.APIResponse;
import com.diit.common.base.response.ResponseCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final ISysUserService iSysUserService;

    /**
     * 获取用户信息
     */
    @GetMapping("/username/{username}")
    public APIResponse getUserByUsername(@PathVariable String username) {
        UserAuthDTO user = iSysUserService.getByUsername(username);
        return new APIResponse(ResponseCode.SUCCESS, user);
    }
}