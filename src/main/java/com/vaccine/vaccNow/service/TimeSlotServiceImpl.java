package com.vaccine.vaccNow.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vaccine.vaccNow.dto.VaccineDTO;
import com.vaccine.vaccNow.model.TimeSlot;
import com.vaccine.vaccNow.repository.IBranchRepository;
import com.vaccine.vaccNow.repository.ITimeSlotRepository;
import com.vaccine.vaccNow.repository.IVaccineRepository;
import com.vaccine.vaccNow.utils.EmailServiceUtil;
@Service
public class TimeSlotServiceImpl implements ITimeSlotService {

	@Autowired
	IBranchRepository branchRepo;

	@Autowired
	IVaccineRepository vaccineRepo;

	@Autowired
	ITimeSlotRepository timeSlotRepo;
	
	@Autowired
	private EmailServiceUtil emailServiceUtil;
	
	@Override
	public String scheduleVaccinationTimeslot(VaccineDTO scheduleTimeslotDTO) {

		String response = null;
		Date slotFrom = null, slotTo = null;
		 SimpleDateFormat formatter6=new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
		 try {
			slotFrom=formatter6.parse(scheduleTimeslotDTO.getStartTime());
			slotTo=formatter6.parse(scheduleTimeslotDTO.getEndTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		// saving time slot
		TimeSlot scheduleTimeslot = new TimeSlot();
		scheduleTimeslot.setBranch(branchRepo.findById(scheduleTimeslotDTO.getBranchId()).orElse(null));
		scheduleTimeslot.setVaccine(vaccineRepo.findById(scheduleTimeslotDTO.getVaccineId()).orElse(null));
		scheduleTimeslot.setEmail(scheduleTimeslotDTO.getEmail());
		scheduleTimeslot.setTransactionId(UUID.randomUUID().toString());
		scheduleTimeslot.setTransactionStatus("INITIATED");
		scheduleTimeslot.setTimeSlotFrom(slotFrom);
		scheduleTimeslot.setTimeSlotTo(slotTo);
		scheduleTimeslot.setCreatedAt(Calendar.getInstance().getTime());
		scheduleTimeslot.setSlotId(scheduleTimeslotDTO.getId());
		scheduleTimeslot.setModifiedAt(Calendar.getInstance().getTime());
		timeSlotRepo.save(scheduleTimeslot);

		// Sending scheduled email
			emailServiceUtil.sendScheduleMail(scheduleTimeslot);

		response = "SUCCESS";
		return response;
	}

	
}
