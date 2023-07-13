package com.iiht.fse4.skilltracker.engineer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EngineerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EngineerServiceApplication.class, args);
	}

}
