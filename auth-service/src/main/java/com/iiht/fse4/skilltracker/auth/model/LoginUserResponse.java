package com.iiht.fse4.skilltracker.auth.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class LoginUserResponse {
    private String token;
    private String type;
    private UserInfo userInfo;
    private HttpStatus status;
    private String message;
}
