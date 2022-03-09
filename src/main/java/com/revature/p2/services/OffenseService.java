package com.revature.p2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.p2.models.Offense;
import com.revature.p2.repository.OffenseDAO;

@Service
public class OffenseService {
	
	@Autowired
	private OffenseDAO offenseDAO;
	
	public Offense addOffense(Offense offense) {
		return offenseDAO.save(offense);
	}
	
	public List<Offense> getAllOffenses(){
		return (List<Offense>)offenseDAO.findAll();
	}
	
	@Transactional
	public void updateOffense(Offense updatedOffense) {
		offenseDAO.save(updatedOffense);	
	}
	
	@Transactional
	public void deleteOffense(Offense offenseDelete) {
		// Check if the offender exists
		if(offenseDAO.existsById(offenseDelete.getId())){
			
			offenseDAO.delete(offenseDelete);
		}
		else {
			System.out.println("Offense does not exist");
		}
			
	}
	
	@Transactional
	public void deleteOffenseById(int id) {
		// Check if the offender exists
		if(offenseDAO.existsById(id)){
			
			offenseDAO.deleteById(id);
		}
		else {
			System.out.println("Offense does not exist");
		}
			
	}
}