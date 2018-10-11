package com.apap.tutorial5.service;

import com.apap.tutorial5.model.FlightModel;

public interface FlightService {
	void addFlight (FlightModel flight);
	
	FlightModel getFlightByFlightNumber(String flightNumber);
	
	void deleteFlight (FlightModel flight);
	
	void deleteFlightbyId(long flightId);
}
