package com.vaccine.vaccNow.service;

import java.util.List;

import com.vaccine.vaccNow.dto.VaccineDTO;
import com.vaccine.vaccNow.model.Branch;
import com.vaccine.vaccNow.model.Vaccine;

public interface IBranchService {

	public void saveBranch(VaccineDTO vaccineDTO);
	
	public void saveTimeSlot(Branch b);
	
	public  Branch getAllBranch() ;

	public List<Branch> getAllBranchNames();
	
	public List<Vaccine> getVaccinePerBranch();


	public List<Branch> getAvailabilityByBranch();
	
	
	

}
