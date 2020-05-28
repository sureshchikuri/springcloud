package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class GoEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoEurekaApplication.class, args);
	}

}
