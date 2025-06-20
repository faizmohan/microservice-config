package com.hotel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HotelServiceApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", "HOTEL-SERVICE");
		SpringApplication.run(HotelServiceApplication.class, args);
	}

}
