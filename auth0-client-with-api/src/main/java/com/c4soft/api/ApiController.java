package com.c4soft.api;

import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4soft.feign.Auth0FeignClient;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final Auth0FeignClient auth0;

    @GetMapping("/api/user-count")
    public UserCountDto getUserCount(JwtAuthenticationToken auth) {
        return new UserCountDto(auth0.getTotalUsers());
    }

    public static record UserCountDto(Long totalUsers) {}
}
