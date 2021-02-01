package com.vaccine.vaccNow.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.FutureTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaccine.vaccNow.dto.VaccineDTO;
import com.vaccine.vaccNow.model.Branch;
import com.vaccine.vaccNow.model.TimeSlot;
import com.vaccine.vaccNow.model.Vaccine;
import com.vaccine.vaccNow.repository.IBranchRepository;
import com.vaccine.vaccNow.repository.ITimeSlotRepository;
import com.vaccine.vaccNow.repository.IVaccineRepository;

@Service
public class BranchServiceImpl implements IBranchService {
	@Autowired
	IBranchRepository branchRepo;

	@Autowired
	IVaccineRepository vaccineRepo;

	@Autowired
	ITimeSlotRepository timeSlotRepo;

	@Override
	public void saveBranch(VaccineDTO vaccineDTO) {
		Branch b = new Branch();
		b.setBranchName(vaccineDTO.getBranchName());
		List<Vaccine> vaccList = new ArrayList<Vaccine>();
		Vaccine v = new Vaccine();
		v.setAvailableVaccine(vaccineDTO.getAvailableVaccine());
		v.setVaccineName(vaccineDTO.getVaccineName());
		v.setDate(new Date());
		v.setBranch(b);
		vaccList.add(v);
		branchRepo.save(b);
		vaccineRepo.save(v);
		
	}
	
	@Override
	public Branch getAllBranch() {
		return (Branch) branchRepo.findById(1).get();
		
		

	}

	@Override
	public List<Branch> getAllBranchNames() {
		return (List<Branch>) branchRepo.findAll();
		
		

	}
	
	@Override
	public List<Vaccine> getVaccinePerBranch() {
		//Optional<Branch> b=branchRepo.findById(1);
		 Branch b1=branchRepo.findOneById(1);
		ObjectMapper ob=new ObjectMapper();
		
		return ( List<Vaccine>) b1.getVaccineList();

	}

	@Override
	public List<Branch> getAvailabilityByBranch()
	{
		
		return ( List<Branch>) branchRepo.findAll();
		 
	}

	@Override
	public void saveTimeSlot(Branch b) {
	
		
	}


}
