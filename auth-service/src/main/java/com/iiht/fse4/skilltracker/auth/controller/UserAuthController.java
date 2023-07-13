package com.iiht.fse4.skilltracker.auth.controller;

import com.iiht.fse4.skilltracker.auth.model.AddUserResponse;
import com.iiht.fse4.skilltracker.auth.model.LoginUserResponse;
import com.iiht.fse4.skilltracker.auth.model.UserInfo;
import com.iiht.fse4.skilltracker.auth.model.ValidateUserResponse;
import com.iiht.fse4.skilltracker.auth.service.UserInfoService;
import com.iiht.fse4.skilltracker.auth.util.AuthConstants;
import com.iiht.fse4.skilltracker.auth.util.SecurityUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = AuthConstants.AUTH_API)
public class UserAuthController {

    @Autowired
    private UserInfoService userInfoService;

    @GetMapping("/hello")
    private String helloUser() {
        return "Hello User! Welcome to FSE4 Accreditation";
    }

    @PostMapping("/addUser")
    public ResponseEntity<AddUserResponse> addUserInfo(@RequestBody UserInfo userInfo) {
        AddUserResponse response = userInfoService.addUser(userInfo);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUserResponse> authenticateUser(@RequestHeader HttpHeaders headers) {
        final Pair<String, String> userNamePassword = SecurityUtil.decodeBase64(headers);
        LoginUserResponse response = userInfoService.authenticateUser(userNamePassword);
        return new ResponseEntity<>(response, response.getStatus());
    }

    @PostMapping("/validateUser")
    public ResponseEntity<ValidateUserResponse> validateUser(@RequestHeader HttpHeaders headers) {
        String token = SecurityUtil.extractToken(headers);
        ValidateUserResponse response = userInfoService.validateUser(token);
        return new ResponseEntity<>(response, response.getStatus());
    }
}
