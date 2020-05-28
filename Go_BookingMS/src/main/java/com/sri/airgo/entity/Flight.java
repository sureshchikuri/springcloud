package com.sri.airgo.entity;

import java.util.Date;


public class Flight {
	
	private String flightId;
	private String source;
	private String destination;
	private String airlines;
	private double fare;
	
	private Date flightAvailableDate;
	private Integer seatCount;

	private String departureTime;
	private String arrivalTime;

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Date getFlightAvailableDate() {
		return flightAvailableDate;
	}

	public void setFlightAvailableDate(Date flightAvailableDate) {
		this.flightAvailableDate = flightAvailableDate;
	}

	public Integer getSeatCount() {
		return seatCount;
	}

	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

	public String getSource() {
		return source;
	}

	public String getDestination() {
		return destination;
	}

	public double getFare() {
		return fare;
	}

	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlines() {
		return airlines;
	}

	public void setAirlines(String airlines) {
		this.airlines = airlines;
	}

}
