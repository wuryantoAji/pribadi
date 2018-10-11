package com.apap.tutorial5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.apap.tutorial5.model.FlightModel;
import com.apap.tutorial5.model.PilotModel;
import com.apap.tutorial5.service.FlightService;
import com.apap.tutorial5.service.PilotService;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private PilotService pilotService;
	
	@RequestMapping(value = "/flight/add/{licenseNumber}", method=RequestMethod.GET)
	private String add(@PathVariable(value="licenseNumber") String licenseNumber, Model model) {
		FlightModel flight = new FlightModel();
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		
		model.addAttribute("flight", flight);
		return "addFlight";
	}
	
	@RequestMapping(value = "/flight/add",method = RequestMethod.POST)
	private String addFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "add";
	}
	
	
	@RequestMapping(value = "/flight/update/{licenseNumber}/{flightNumber}", method=RequestMethod.GET)
	private String updateFlight(@PathVariable(value="licenseNumber") String licenseNumber,
								@PathVariable(value="flightNumber") String flightNumber,
								Model model) {
		FlightModel flight = flightService.getFlightByFlightNumber(flightNumber);
		PilotModel pilot = pilotService.getPilotDetailByLicenseNumber(licenseNumber);
		flight.setPilot(pilot);
		model.addAttribute("flight", flight);
		return "updateFlight";
	}
	
	@RequestMapping(value = "/flight/update",method = RequestMethod.POST)
	private String updateFlightSubmit(@ModelAttribute FlightModel flight) {
		flightService.addFlight(flight);
		return "update";
	}
	
	@RequestMapping(value = "/flight/view",method = RequestMethod.GET)
	private String viewFlight(@RequestParam("flightNumber") String flightNumber, Model model) {
		FlightModel flight = flightService.getFlightByFlightNumber(flightNumber);
		model.addAttribute("penerbangan", flight);
		return "flightList";
	}
	
	@RequestMapping(value = "/flight/delete", method = RequestMethod.POST)
	private String deleteFlight(@ModelAttribute PilotModel pilot, Model model) {
//		FlightModel flight = flightService.getFlightByFlightNumber(flightNumber);
//		flightService.deleteFlight(flight);
		for(FlightModel flight : pilot.getPilotFlight()) {
			flightService.deleteFlightbyId(flight.getId());
		}
		return "delete";
	}
	
	
}
