package com.revature.p2.servlet;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.p2.dto.DeputyRequest;
import com.revature.p2.dto.OffenderRequest;
import com.revature.p2.models.Deputy;
import com.revature.p2.models.Offender;
import com.revature.p2.newservices.Deputyservice;
import com.revature.p2.newservices.Offenderservice;

@RestController
@RequestMapping("/offenders")
public class OffenderServlet {
	
	private final Offenderservice offenderService;
	
	@Autowired
	public OffenderServlet(Offenderservice  offenderService) {
		this.offenderService =  offenderService;
	}
	
	@GetMapping("/getAllOffenders")
	public List<Offender> getAllOffenders(){

	return offenderService.getAllDeputies();
		}
	
	
	
	
	
	@PostMapping("/add/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDeputy(@RequestBody @Valid OffenderRequest offenderRequest) {
		offenderRequest.setDeputy(null)
	}
	
	


}