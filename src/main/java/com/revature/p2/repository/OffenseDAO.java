package com.revature.p2.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.models.Offense;

@Repository
public interface OffenseDAO extends CrudRepository<Offense, Integer>{

	@Query("from Offense o where o.id = :id")
	Offense findOffenseById(int id);
}
