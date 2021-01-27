package com.vaccine.vaccNow.service;

import java.util.Map;

import com.vaccine.vaccNow.dto.BranchDTO;

public interface IBranchVaccineService {

	Map<String, BranchDTO> getScheduleVaccinationByBranch(Integer branchId);

}
