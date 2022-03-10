package com.revature.p2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.models.Offender;

@Repository
public interface OffenderDAO extends CrudRepository<Offender, Integer>{

	@Query("from Offender o where o.id = :id")
	Offender findOffenderById(int id);
	
}
