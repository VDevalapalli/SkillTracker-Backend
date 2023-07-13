package com.iiht.fse4.skilltracker.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SkillTrackerEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillTrackerEurekaServerApplication.class, args);
    }
}