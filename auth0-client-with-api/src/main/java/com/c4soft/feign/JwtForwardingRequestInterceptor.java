package com.c4soft.feign;

import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@Component
public class JwtForwardingRequestInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        if (SecurityContextHolder.getContext().getAuthentication() instanceof JwtAuthenticationToken jwtAuth) {
            template.header(HttpHeaders.AUTHORIZATION, "Bearer %s".formatted(jwtAuth.getToken().getTokenValue()));
        }
    }
}
