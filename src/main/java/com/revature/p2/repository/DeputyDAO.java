package com.revature.p2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.revature.p2.models.Deputy;

@Repository
public interface DeputyDAO extends CrudRepository<Deputy, Integer> {
	
	@Query("from Deputy o where o.id = :id")
	Deputy findDeputyById(int id);
	
	Optional<Deputy> findDeputyByEmail(String email);
	Optional<Deputy> findDeputyByUsername(String username);
	
	@Query("from Deputy d where d.username = :username and d.password = :password")
	Deputy findDeputyByUsernameAndPassword(String username, String password);

}
