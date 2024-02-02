package com.c4soft.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "auth0-api")
public interface Auth0FeignClient {

    default Long getTotalUsers() {
        return getUsers(true, 0).total();
    }

    @GetMapping(value = "/users")
    Auth0UserPageDto getUsers(@RequestParam("include_totals") boolean includeTotals, @RequestParam("per_page") int perPage);

    public static record Auth0UserPageDto(Long total) {}
}
