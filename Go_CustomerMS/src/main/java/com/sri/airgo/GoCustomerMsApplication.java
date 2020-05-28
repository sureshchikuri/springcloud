package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
@EnableDiscoveryClient
public class GoCustomerMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoCustomerMsApplication.class, args);
	}

}
