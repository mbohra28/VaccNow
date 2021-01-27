package com.vaccine.vaccNow.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccine.vaccNow.dto.BranchDTO;
import com.vaccine.vaccNow.model.TimeSlot;
import com.vaccine.vaccNow.repository.ITimeSlotRepository;


@Service
public class BranchVaccineServiceImpl implements IBranchVaccineService {
	
	@Autowired
	ITimeSlotRepository timeSlotRepo;

	@Override
	public Map<String, BranchDTO> getScheduleVaccinationByBranch(Integer branchId) {
		Map<String, BranchDTO> mapVaccineByBranch = new HashMap<>();
		List<TimeSlot> timeSlotList = (List<TimeSlot>) timeSlotRepo.findAll();
		for (TimeSlot timeSlot : timeSlotList) {
			BranchDTO branchDTO= new BranchDTO();
			if(timeSlot.getBranch().getBranchId()==branchId)
			{
			if(timeSlot.getTransactionStatus().equals("INITIATED"))
			{
			branchDTO.setBranchName(timeSlot.getBranch().getBranchName());
			branchDTO.setId(timeSlot.getBranch().getBranchId());
			mapVaccineByBranch.put(timeSlot.getVaccine().getVaccineName(),branchDTO);
			}
			}
		}
		return mapVaccineByBranch;
	}
	
}
