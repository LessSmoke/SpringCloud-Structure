package com.diit.auth.web;

import com.diit.common.base.response.APIResponse;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.endpoint.TokenEndpoint;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.*;

import java.security.KeyPair;
import java.security.Principal;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Map;

/**
 * @author yjxbz
 */
@RestController
@RequestMapping("/oauth")
@AllArgsConstructor
@Slf4j
public class AuthController {

    private final KeyPair keyPair;

    private final TokenEndpoint tokenEndpoint;

    /**
     * 获取token接口
     * @param principal
     * @param parameters
     * @return APIResponse
     * @throws HttpRequestMethodNotSupportedException
     */
    @PostMapping("/token")
    public APIResponse postAccessToken(Principal principal, @RequestParam Map<String,String> parameters) throws HttpRequestMethodNotSupportedException {
        OAuth2AccessToken token = tokenEndpoint.postAccessToken(principal,parameters).getBody();
        return new APIResponse(200,"获取token成功",token);
    }


    @GetMapping("/public-key")
    public Map<String,Object> getPublicKey(){
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        return new JWKSet((JWK) publicKey).toJSONObject();
    }
}
