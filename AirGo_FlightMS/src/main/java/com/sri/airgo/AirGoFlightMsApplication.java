package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AirGoFlightMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirGoFlightMsApplication.class, args);
	}

}
