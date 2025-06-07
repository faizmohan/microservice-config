package com.rate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", "RATING-SERVICE");
		SpringApplication.run(RatingServiceApplication.class, args);
	}

}
