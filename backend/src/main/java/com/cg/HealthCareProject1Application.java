package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HealthCareProject1Application {

	public static void main(String[] args) {
		SpringApplication.run(HealthCareProject1Application.class, args);
	}

}
