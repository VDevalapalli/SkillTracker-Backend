package com.iiht.fse4.skilltracker.api.gateway.hystrix;

import com.iiht.fse4.skilltracker.api.gateway.client.AuthServiceClient;
import org.springframework.stereotype.Component;

@Component
public class AuthServiceFallBack implements AuthServiceClient {

    @Override
    public void validateUser(Long userId) {
    }
}
