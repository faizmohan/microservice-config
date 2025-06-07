package com.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {

	public static void main(String[] args) {
		System.setProperty("spring.application.name", "CONFIG-SERVER");
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
