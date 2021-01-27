package com.vaccine.vaccNow.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","branch","vaccine"})
public class TimeSlot {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer slotId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "branch_id")
	private Branch branch;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vaccine_id")
	private Vaccine vaccine;
	
	private Date timeSlotFrom;
	
	private Date timeSlotTo;
	
	private String transactionId;	
	
	private String transactionStatus;
	
	private String vaccinactionDone;
	
	private String email;
	
	private Date modifiedAt;
	
	private Date createdAt;

	public Integer getSlotId() {
		return slotId;
	}

	public void setSlotId(Integer slotId) {
		this.slotId = slotId;
	}




	public String getVaccinactionDone() {
		return vaccinactionDone;
	}

	public void setVaccinactionDone(String vaccinactionDone) {
		this.vaccinactionDone = vaccinactionDone;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

	
	
	public Date getTimeSlotFrom() {
		return timeSlotFrom;
	}

	public void setTimeSlotFrom(Date timeSlotFrom) {
		this.timeSlotFrom = timeSlotFrom;
	}

	public Date getTimeSlotTo() {
		return timeSlotTo;
	}

	public void setTimeSlotTo(Date timeSlotTo) {
		this.timeSlotTo = timeSlotTo;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionStatus() {
		return transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		this.transactionStatus = transactionStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	

}
