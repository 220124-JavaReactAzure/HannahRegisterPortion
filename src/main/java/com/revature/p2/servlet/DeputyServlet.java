package com.revature.p2.servlet;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.cloudfoundry.CloudFoundryAuthorizationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.p2.dto.DeputyRequest;
import com.revature.p2.dto.DeputyResponse;
import com.revature.p2.models.Deputy;
import com.revature.p2.newservices.Deputyservice;



@RestController
@RequestMapping("/deputies")
public class DeputyServlet {

	private final Deputyservice deputyService;
	
	@Autowired
	public DeputyServlet(Deputyservice deputyService) {
		this.deputyService = deputyService;
	}
	
	@GetMapping("/getAllDeputies")
	public List<Deputy> getAllDeputies(){

	return deputyService.getAllDeputies();
		}
	
	
	
	
	
	@PostMapping("/addDeputy")
	@ResponseStatus(HttpStatus.CREATED)
	public void createDeputy(@RequestBody @Valid DeputyRequest deputyRequest) {
		deputyService.registerNewDeputy(deputyRequest);
	}
	
	
//	@GetMapping("/email")
//	public ResponseEntity<Void> checkEmail(@RequestParam String email){
//		return scientistService.isEmailAvailable(email) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
//	}
//	
//	@GetMapping("/username")
//	public ResponseEntity<Void> checkUsername(@RequestParam String username){
//		return scientistService.isUsernameAvailable(username) ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(HttpStatus.CONFLICT);
//	}
	
//	@PatchMapping(consumes = "application/json")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
//	public void updateScientistInfo(@RequestBody UpdateScientistRequest updateScientistRequest, HttpServletRequest req) {
//		HttpSession session = req.getSession(false);
//		if(session == null) {
//			throw new AuthenticationException("No session found");
//		}
//		
//		Scientist requestingScientist = (Scientist) session.getAttribute("authScientist");
//		
//		boolean requestEditSelf = requestingScientist.getScientistId().equals(updateScientistRequest.getScientistId());
//		
//		if(!requestEditSelf) {
//			throw new AuthorizationException("forbidden request");
//		}
//		
//		scientistService.updateScientist(updateScientistRequest);
//	}
	
}