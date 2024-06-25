package com.diit.admin.web.web;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.diit.admin.starter.dto.OAuth2ClientDTO;
import com.diit.admin.web.domain.SysOauthClient;
import com.diit.admin.web.service.ISysOauthClientService;
import com.diit.common.base.response.APIResponse;
import com.diit.common.base.response.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/oauth-clients")
@Slf4j
@AllArgsConstructor
@RestController
public class OauthClientController {
    private ISysOauthClientService iSysOauthClientService;

    @GetMapping("/getOAuth2ClientById")
    public APIResponse getOAuth2ClientById(@RequestParam String clientId) {
        SysOauthClient client = iSysOauthClientService.getById(clientId);
        Assert.notNull(client, "OAuth2 客户端不存在");
        OAuth2ClientDTO oAuth2ClientDTO = new OAuth2ClientDTO();
        BeanUtil.copyProperties(client, oAuth2ClientDTO);
        return new APIResponse(ResponseCode.SUCCESS,oAuth2ClientDTO);
    }
}