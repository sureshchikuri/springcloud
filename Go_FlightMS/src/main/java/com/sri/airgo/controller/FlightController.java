package com.sri.airgo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sri.airgo.dto.SearchFlights;
import com.sri.airgo.entity.Flight;
import com.sri.airgo.exception.ARSServiceException;
import com.sri.airgo.service.FlightService;
import com.sri.airgo.utility.MyDateEditor;



@RestController
@RequestMapping("/flights")
@CrossOrigin
public class FlightController {

	protected Logger logger = Logger.getLogger(FlightController.class.getName());

	@Autowired
	private FlightService flightService;

	@InitBinder
	public void myInitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new MyDateEditor(format));
	}

	@GetMapping("/{flightId}")
	public Flight getFlights(@PathVariable("flightId") String flightId) throws ARSServiceException {
		System.out.println("flight id" + flightId);
		//if(flightId.equals("F102")) {
		//	throw new RuntimeException();
		//}
		return flightService.getFlights(flightId);
	}

	@RequestMapping(value = "/sources", method = RequestMethod.GET)
	public List<String> getFlightSources() throws ARSServiceException {
		System.out.println("In get sources");
		return flightService.getSources();
	}

	@RequestMapping(value = "/destinations", method = RequestMethod.GET)
	public List<String> getFlightDestinations() throws ARSServiceException {
		System.out.println("In get sources");
		return flightService.getDestinationss();
	}

	@RequestMapping(value = "/{source}/{destination}/{journeyDate}", method = RequestMethod.GET)
	public ResponseEntity<List<SearchFlights>> getFlightDetails(@PathVariable String source,
			HttpServletResponse response, @PathVariable String destination, @PathVariable Date journeyDate) {
		List<SearchFlights> availableFlights = flightService.getFlights(source, destination, journeyDate);
		return new ResponseEntity<List<SearchFlights>>(availableFlights, HttpStatus.OK);

	}

	@RequestMapping(value = "/{flightId}/{noOfSeats}")
	public void updateFlightSeat(@PathVariable String flightId, @PathVariable int noOfSeats)
			throws ARSServiceException {
		flightService.updateFlight(flightId, noOfSeats);

	}
}