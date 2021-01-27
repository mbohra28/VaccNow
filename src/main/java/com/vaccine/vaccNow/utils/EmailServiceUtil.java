package com.vaccine.vaccNow.utils;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.vaccine.vaccNow.model.TimeSlot;

@Service
public class EmailServiceUtil {
	private final Logger log = LoggerFactory.getLogger(getClass().getName());
	
	public void sendScheduleMail(TimeSlot scheduleTimeslot) {
		log.info("Sending mail to " + scheduleTimeslot.getEmail());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String msg = "\n\n\n"
				+ "Hello "+scheduleTimeslot.getEmail()+","
				+ "\nYou have scheduled appointment for " + scheduleTimeslot.getVaccine().getVaccineName()
				+ " at " + scheduleTimeslot.getBranch().getBranchName()
				+ " - " + sdf.format(scheduleTimeslot.getTimeSlotFrom())
				+ ".\n\n\n";
		log.info(msg);
	}

}