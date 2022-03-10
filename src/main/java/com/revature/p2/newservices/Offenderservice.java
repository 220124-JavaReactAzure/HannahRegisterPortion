package com.revature.p2.newservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.revature.p2.dto.DeputyRequest;
import com.revature.p2.dto.OffenderRequest;
import com.revature.p2.exceptions.ResourcePersistenceException;
import com.revature.p2.models.Deputy;
import com.revature.p2.models.Offender;
import com.revature.p2.repository.DeputyDAO;
import com.revature.p2.repository.OffenderDAO;

public class Offenderservice {
	
	private final OffenderDAO offenderDAO;

	@Autowired
	public Offenderservice(OffenderDAO offenderDAO) {
		this.offenderDAO = offenderDAO;
	}
	
	
	@Transactional
	public boolean registerNewOffender(OffenderRequest offenderRequest) {
		
		Offender offender = new Offender(
				offenderRequest.getId(),
				offenderRequest.getSrc(),
				offenderRequest.getFullname(),
				offenderRequest.getAlias(),
				offenderRequest.getDob(),
				offenderRequest.getSex(),
				offenderRequest.getHeight(),
				offenderRequest.getWeight(),
				offenderRequest.getEyes(),
				offenderRequest.getHeight(),
				offenderRequest.getOrderBy()
				);

		Offender persistedOffender = offenderDAO.save(offender);

		
		if(persistedOffender == null) {
			throw new ResourcePersistenceException("The deputy could not be persisted");
		}
		
		return true;
	}
	
	@Transactional
	public List<Offender> getAllOffenders(){
		return (List<Offender>) offenderDAO.findAll();	
	}
	
	
	

}
