package com.vaccine.vaccNow.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

@Table
public class Vaccine {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer vaccineId;
	private String vaccineName;
	
	@ManyToOne
	@JoinColumn(name="branchId", nullable=false)
	private Branch branch;

	private int availableVaccine;

	private Date date;

	


	public Integer getVaccineId() {
		return vaccineId;
	}

	public void setVaccineId(Integer vaccineId) {
		this.vaccineId = vaccineId;
	}

	public String getVaccineName() {
		return vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public int getAvailableVaccine() {
		return availableVaccine;
	}

	public void setAvailableVaccine(int availableVaccine) {
		this.availableVaccine = availableVaccine;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
