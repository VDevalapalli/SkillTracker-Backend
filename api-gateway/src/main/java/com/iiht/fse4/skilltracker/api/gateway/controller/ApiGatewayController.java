package com.iiht.fse4.skilltracker.api.gateway.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-gateway")
@Slf4j
public class ApiGatewayController {
    @GetMapping("/security")
    public ResponseEntity<String> securityConfig() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
