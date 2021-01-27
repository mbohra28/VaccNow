package com.vaccine.vaccNow.repository;

import org.springframework.data.repository.CrudRepository;

import com.vaccine.vaccNow.model.TimeSlot;

public interface ITimeSlotRepository extends  CrudRepository<TimeSlot, Integer>{

}
