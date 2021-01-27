package com.vaccine.vaccNow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vaccine.vaccNow.model.Vaccine;
	@Repository
	public interface IVaccineRepository extends CrudRepository<Vaccine, Integer>
	{

	}
