package com.vaccine.vaccNow.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vaccine.vaccNow.model.Branch;
@Repository
public interface IBranchRepository extends CrudRepository<Branch, Integer>
{
	@Query("from Branch where branchId = :branchId")
 Branch findOneById(@Param(value = "branchId") Integer branchId);
}
