package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
@CrossOrigin
public class AirGoBookingtMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirGoBookingtMsApplication.class, args);
	}
	
	//@Bean
	//public RestTemplate getRestTemplate() {
	//	return new RestTemplate();
	//}

}
