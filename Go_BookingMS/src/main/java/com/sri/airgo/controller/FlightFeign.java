package com.sri.airgo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sri.airgo.entity.Flight;

@FeignClient("FlightMS")
public interface FlightFeign {

	@RequestMapping("/InfyGoBoot/flights/{flightId}")
	Flight getFlightDetails(@PathVariable("flightId") String flightId);
}
