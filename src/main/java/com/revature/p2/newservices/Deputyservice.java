package com.revature.p2.newservices;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.p2.dto.DeputyRequest;
import com.revature.p2.dto.DeputyResponse;
import com.revature.p2.exceptions.AuthenticationException;
import com.revature.p2.exceptions.InvalidRequestException;
import com.revature.p2.exceptions.ResourcePersistenceException;
import com.revature.p2.models.Deputy;
import com.revature.p2.repository.DeputyDAO;


@Service
public class Deputyservice {

	private final DeputyDAO deputyDAO;

	@Autowired
	public Deputyservice(DeputyDAO deputyDAO) {
		this.deputyDAO = deputyDAO;
	}
	
	@Transactional
	public boolean registerNewDeputy(DeputyRequest deputyRequest) {
		
		Deputy newDeputy = new Deputy(
				deputyRequest.getId(),
				deputyRequest.getUsername(),
				deputyRequest.getEmail(),
				deputyRequest.getPassword()
		);

		boolean usernameAvailable = deputyDAO.findDeputyByUsername(newDeputy.getUsername()).isPresent();
		boolean emailAvailable = deputyDAO.findDeputyByEmail(newDeputy.getEmail()).isPresent();

		if(!usernameAvailable || !emailAvailable) {
			if(emailAvailable) {
				throw new ResourcePersistenceException("The provided username was already taken in the database");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email was already taken in the database");
			} 
		}
		Deputy persistedDeputy = deputyDAO.save(newDeputy);

		
		if(persistedDeputy == null) {
			throw new ResourcePersistenceException("The deputy could not be persisted");
		}
		
		return true;
	}
	
	@Transactional
	public List<Deputy> getAllDeputies(){
		return (List<Deputy>) deputyDAO.findAll();	
	}
	
	@Transactional
	public Deputy authenticateDeputy(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		Deputy authenticatedDeputy = deputyDAO.findDeputyByUsernameAndPassword(username, password);
		
		if(authenticatedDeputy == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		return authenticatedDeputy;
	}
	

	
//	@Transactional
//	public void updateDeputy(UpdateScientistRequest updateScientistRequest) {
//		try {
//			
//			Scientist original = scientistDao.findById(updateScientistRequest.getScientistId()).orElseThrow(ResourceNotFoundException::new);
//			
//			Predicate<String> notNullorEmpty = str -> str != null && !str.equals("");
//			
//			if(notNullorEmpty.test(updateScientistRequest.getFirstName())) {
//				original.setFirstName(updateScientistRequest.getFirstName());
//			} else if(notNullorEmpty.test(updateScientistRequest.getLastName())) {
//				original.setLastName(updateScientistRequest.getLastName());
//			} else if(notNullorEmpty.test(updateScientistRequest.getEmail())) {
//				if(scientistDao.findScientistByEmail(updateScientistRequest.getEmail()).isPresent()) {
//					throw new ResourcePersistenceException("The provided email is already in use");
//				}
//				original.setEmail(updateScientistRequest.getEmail());
//			} else if(notNullorEmpty.test(updateScientistRequest.getPassword())) {
//				original.setPassword(updateScientistRequest.getPassword());
//			}
//			
//		} catch (ResourcePersistenceException e) {
//			throw e;
//		} catch (Exception e) {
//			throw new ResourcePersistenceException("Could not update user to due our exception checking");
//		}
//	}
	
	
	
	
	// I am not sure if this will work
	@Transactional
	public boolean isEmailAvailable(String email) {
		return deputyDAO.findDeputyByEmail(email) != null;
		// or try .isEmpty() at the end
		
	}
	
	@Transactional
	public boolean isUsernameAvailable(String username) {
		return deputyDAO.findDeputyByUsername(username) != null;
	}
	
	
}
