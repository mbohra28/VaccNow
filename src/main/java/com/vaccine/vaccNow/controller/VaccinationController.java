package com.vaccine.vaccNow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.vaccNow.dto.VaccineDTO;
import com.vaccine.vaccNow.service.IBranchService;
import com.vaccine.vaccNow.service.ITimeSlotService;

@RestController
@RequestMapping(value = ("/vaccination"))
public class VaccinationController {
	
	@Autowired
	ITimeSlotService service;
	
	@PostMapping(value = "/scheduleVaccinationTimeslot")
	public ResponseEntity<String> scheduleVaccinationTimeslot(@RequestBody VaccineDTO scheduleTimeslotDTO) {
		
		return new ResponseEntity<>(service.scheduleVaccinationTimeslot(scheduleTimeslotDTO), HttpStatus.OK);
	}
	
	

}
