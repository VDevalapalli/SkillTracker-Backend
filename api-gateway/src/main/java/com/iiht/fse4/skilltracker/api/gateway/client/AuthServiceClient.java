package com.iiht.fse4.skilltracker.api.gateway.client;

import com.iiht.fse4.skilltracker.api.gateway.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-client",
        url = "${auth.service.uri}",
        configuration = FeignClientConfig.class)
public interface AuthServiceClient {
    @GetMapping(value = "/validateUser")
    void validateUser(@PathVariable Long userId);
}
