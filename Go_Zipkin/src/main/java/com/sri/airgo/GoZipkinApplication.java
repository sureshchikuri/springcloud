package com.sri.airgo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class GoZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoZipkinApplication.class, args);
	}

}
