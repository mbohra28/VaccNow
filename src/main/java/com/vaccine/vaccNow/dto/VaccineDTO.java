package com.vaccine.vaccNow.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccineDTO implements Serializable{
	private Integer id;
	private Integer branchId;
	private Integer vaccineId;
	private String startTime;
	private String endTime;
	private String availableVaccine;
	private String vaccineName;
	private String branchName;
	private String email;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBranchId() {
		return branchId;
	}
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}
	public Integer getVaccineId() {
		return vaccineId;
	}
	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvailableVaccine() {
		return availableVaccine;
	}
	public void setAvailableVaccine(String availableVaccine) {
		this.availableVaccine = availableVaccine;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	
	
}
