package com.diit.auth.security.details.client;

import com.diit.auth.common.enums.PasswordEncoderTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

@Service("ClientDetailsServiceImpl")
@RequiredArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        // todo 实际上这里应该通过Feign接口从管理端获取，就这里目前写死

        // 授权模式password-密码模式,client_credentials,refresh_token-刷新token,authorization_code-授权码模式
        BaseClientDetails clientDetails = new BaseClientDetails(
                "diit",
                "",
                "all",
                "password,client_credentials,refresh_token,authorization_code",
                "",
                "http://www.baidu.com"
        );
        clientDetails.setClientSecret(PasswordEncoderTypeEnum.NOOP.getPrefix() + "diit");
        clientDetails.setAccessTokenValiditySeconds(3600); // 设置token有效时间
        clientDetails.setRefreshTokenValiditySeconds(36000000); // 设置token刷新后的有效时间
        return null;
    }
}
