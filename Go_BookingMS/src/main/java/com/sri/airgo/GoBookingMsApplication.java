package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
public class GoBookingMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoBookingMsApplication.class, args);
	}

}
