package com.revature.p2.servlet;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.p2.dto.LoginCredentials;
import com.revature.p2.models.Deputy;
import com.revature.p2.newservices.Deputyservice;

@RestController
@RequestMapping("/auth")
public class AuthServlet{

	private final Deputyservice deputyService;
	
	@Autowired
	public AuthServlet(Deputyservice deputyService) {
		this.deputyService = deputyService;
	}
	
	
	@PostMapping
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void authorizeUser(@RequestBody LoginCredentials loginCredentials, HttpSession httpSession) {
		Deputy authDeputy = deputyService.authenticateDeputy(loginCredentials.getUsername(), 
				loginCredentials.getPassword());
		httpSession.setAttribute("authDeputy", authDeputy);
	}
	
	@DeleteMapping
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
}