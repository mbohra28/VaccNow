package com.vaccine.vaccNow.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vaccine.vaccNow.dto.BranchDTO;
import com.vaccine.vaccNow.model.Branch;
import com.vaccine.vaccNow.model.TimeSlot;
import com.vaccine.vaccNow.model.Vaccine;
import com.vaccine.vaccNow.service.IBranchService;
import com.vaccine.vaccNow.service.IBranchVaccineService;

@RestController
@RequestMapping(value = ("/reporting"))
public class ReportingController {
	@Autowired
	IBranchVaccineService service;
	
	
	@GetMapping(value = "/appliedVaccinationPerBranch/{branchId}")
	public ResponseEntity<Map<String, BranchDTO>> appliedVaccinationPerBranch(
			@PathVariable Integer branchId) {
		return ResponseEntity.ok(service.getScheduleVaccinationByBranch(branchId));
	}

}
