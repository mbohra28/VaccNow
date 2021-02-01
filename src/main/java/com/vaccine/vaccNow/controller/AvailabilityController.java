package com.vaccine.vaccNow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.vaccNow.dto.BranchDTO;
import com.vaccine.vaccNow.dto.VaccineDTO;
import com.vaccine.vaccNow.model.Branch;
import com.vaccine.vaccNow.model.TimeSlot;
import com.vaccine.vaccNow.model.Vaccine;
import com.vaccine.vaccNow.service.IBranchService;

@RestController
public class AvailabilityController {
	@Autowired
	IBranchService service;
	
	@GetMapping("/saveBranch")
	public void saveBranch(@RequestBody VaccineDTO vaccineDTO) {
		
	service.saveBranch(vaccineDTO);
		
	}
	

	@GetMapping("/getBranches")
	public ResponseEntity<Object> getBranches() {
		
				return new ResponseEntity<>(service.getAllBranch(), HttpStatus.OK);
		
		
	}
	
	@GetMapping("/getAllVaccinesPerBranch")	
	public ResponseEntity<Object> getAllVaccinesPerBranch() {
		List<Vaccine> vaccineList=new ArrayList<>();
		vaccineList=service.getVaccinePerBranch();
		List<String> vaccineName= new ArrayList<String>();
		for (Vaccine vaccine : vaccineList) {
			vaccineName.add(vaccine.getVaccineName());
		}
		
				return new ResponseEntity<>(vaccineList, HttpStatus.OK);
		
		
	}
	
	
	
	@GetMapping("/getAvailabilityByBranch")	
	public ResponseEntity<Object> getAvailabilityByBranch() {
		List<TimeSlot> timeSlot= new ArrayList<>();
		BranchDTO branchDTO= new BranchDTO();
		List<Branch> lb=service.getAvailabilityByBranch();
		HashMap<String, List<TimeSlot>> hts=new HashMap<String, List<TimeSlot>>();
		for (Branch branch : lb) {
			
			hts.put(branch.getBranchName(),branch.getTimeSlot());
			
		}
		
				return new ResponseEntity<>(hts, HttpStatus.OK);
		
		
	}
	
	
 
	

}
