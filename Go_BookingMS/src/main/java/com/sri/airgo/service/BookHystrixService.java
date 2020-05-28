package com.sri.airgo.service;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.sri.airgo.controller.FlightFeign;
import com.sri.airgo.entity.Flight;

@Service
public class BookHystrixService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	FlightFeign flightFeign;
	
	
	@HystrixCommand
	public Future<Flight> getSpecificFlightDetails(final String flightId) {
		return new AsyncResult<Flight>() {

			@Override
			public Flight invoke() {
				//return restTemplate.getForObject("http://FLIGHTMS"+"/InfyGoBoot/flights/"+flightId, Flight.class);
				return flightFeign.getFlightDetails(flightId);
			}
			
		};
		
	}
	
	

}
