package com.md.saas.authserver.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class CustomerWebResponseExceptionTranslator implements WebResponseExceptionTranslator<OAuth2Exception> {
    private static final String INVALID_TOKEN_ERROR_DESCRIPTION = "Token was not recognised";//token 无效
    private static final String INVALID_AUTHORIZATION_CODE = "Invalid authorization code";//授权码无效
    private static final String INVALID_USER = "无效用户";//密码有误
    private static final String BAD_CREDENTIALS = "Bad credentials";//密码有误

    @Override
    public ResponseEntity translate(Exception e) {
        Map<String, Object> result = new HashMap();
        result.put("code", 400);
        result.put("msg", e.getMessage());
        log.warn("msg {}", e.getMessage());
        return ResponseEntity.ok().body(result);
    }
}
