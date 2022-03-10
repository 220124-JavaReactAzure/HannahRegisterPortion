package com.revature.p2.servlet;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestServlet {

	@GetMapping("/test")
	public String test() {
		return "test works";
	}
	
}