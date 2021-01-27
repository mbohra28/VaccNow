package com.vaccine.vaccNow.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","vaccineList","timeSlot"})

public class Branch {
	 
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer branchId;
	
	private String branchName;
	
	@OneToMany(mappedBy="branch")
	private List<TimeSlot> timeSlot;
	
	@OneToMany(mappedBy="branch")
	private List<Vaccine> vaccineList;

	public List<TimeSlot> getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(List<TimeSlot> timeSlot) {
		this.timeSlot = timeSlot;
	}

	public List<Vaccine> getVaccineList() {
		return vaccineList;
	}

	public void setVaccineList(List<Vaccine> vaccineList) {
		this.vaccineList = vaccineList;
	}


	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
}
