package com.vaccine.vaccNow.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vaccine.vaccNow.model.Branch;
@Repository
public interface IBranchRepository extends CrudRepository<Branch, Integer>
{

}
