package com.sri.airgo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sri.airgo.config.BookRibbonConfig;
import com.sri.airgo.dto.BookingDetails;
import com.sri.airgo.dto.PassengerDetails;
import com.sri.airgo.entity.Flight;
import com.sri.airgo.entity.Passenger;
import com.sri.airgo.entity.Ticket;
import com.sri.airgo.exception.ARSServiceException;
import com.sri.airgo.exception.AirGoServiceException;
import com.sri.airgo.exception.ExceptionConstants;
import com.sri.airgo.service.PassengerService;
import com.sri.airgo.service.TicketService;
import com.sri.airgo.utility.ClientErrorInformation;

@RestController
@CrossOrigin
@RequestMapping("/book")
@EnableAutoConfiguration
@RibbonClient(name = "bookribbon",configuration=BookRibbonConfig.class)
public class BookingController {

	protected Logger logger = Logger.getLogger(BookingController.class.getName());

	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private TicketService ticketService;
	@Autowired
	private PassengerService passengerService;
	private Ticket ticket;
	private int noOfSeats;

	public BookingController() {
		ticket = new Ticket();
	}

	@PostMapping(value = "/{flightId}/{username}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<BookingDetails> bookFlight(@PathVariable("flightId") String flightId,
			@Valid @RequestBody PassengerDetails passengerDetails, @PathVariable("username") String username,
			Errors errors) throws AirGoServiceException, ARSServiceException {

		if (errors.hasErrors()) {
			return new ResponseEntity(new ClientErrorInformation(HttpStatus.BAD_REQUEST.value(),
					errors.getFieldError("passengerList").getDefaultMessage()), HttpStatus.BAD_REQUEST);
		}
		if (passengerDetails.getPassengerList().isEmpty())
			throw new AirGoServiceException(ExceptionConstants.PASSENGER_LIST_EMPTY.toString());

		List<Passenger> passengerList = new ArrayList<Passenger>();
		for (Passenger passengers : passengerDetails.getPassengerList()) {
			passengerList.add(passengers);

		}
		System.out.println(passengerList.toString());

		logger.log(Level.INFO, "Book Flight method ");

		logger.log(Level.INFO, passengerDetails.toString());
		int pnr = (int) (Math.random() * 1858955);

		ticket.setPnr(pnr);
//		Date date = new Date();
//		Calendar calendar = Calendar.getInstance();
//		calendar.setTime(date);

		// Flight flight = flightService.getFlights(flightId); use RestTemplate

		Flight flight = restTemplate.getForObject("http://bookribbon/InfyGoBoot/flights/" + flightId, Flight.class);

		double fare = flight.getFare();
		System.out.println("Fare per person:****** " + fare);
		System.out.println("List size:****** " + passengerDetails.getPassengerList().size());
		double totalFare = fare * (passengerDetails.getPassengerList().size());

		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setPassengerList(passengerDetails.getPassengerList());
		bookingDetails.setPnr(pnr);
		bookingDetails.setTotalFare(totalFare);
		ticket.setBookingDate(new Date());
		System.out.println(ticket.getBookingDate());
		ticket.setDepartureDate(flight.getFlightAvailableDate());
		ticket.setDepartureTime(flight.getDepartureTime());
		ticket.setFlightId(flight.getFlightId());
		ticket.setUserId(username);
		ticket.setTotalFare(totalFare);
		noOfSeats = passengerDetails.getPassengerList().size();
		ticket.setNoOfSeats(noOfSeats);
		ticketService.createTicket(ticket);

		addPassengers(bookingDetails.getPassengerList());

		// flightService.updateFlight(flightId, noOfSeats);use resttemplate
		// restTemplate.postForObject("http://localhost:8082/InfyGoBoot/flights/"+flightId+""+noOfSeats,
		// request, responseType)
		restTemplate.put("http://bookribbon/InfyGoBoot/flights/" + flightId + "/" + noOfSeats, null);

		return new ResponseEntity<BookingDetails>(bookingDetails, HttpStatus.OK);

	}

	private void addPassengers(List<Passenger> passengers) {

		for (Passenger passenger : passengers) {
			passenger.setTicket(ticket);

		}

		passengerService.createPassenger(passengers);

	}

}
