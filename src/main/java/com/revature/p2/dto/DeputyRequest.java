package com.revature.p2.dto;

import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class DeputyRequest {
	
	private int id;
	
	@Size(min=3, max=20)
	private String username;
	
	
	@Email
	private String email;
	
	
	private String password;
	
	


	public DeputyRequest() {
		super();
	}




	public DeputyRequest(int id, String username, String email, String password) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	
	




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getUsername() {
		return username;
	}




	public void setUsername(String username) {
		this.username = username;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	@Override
	public int hashCode() {
		return Objects.hash(email, password, username);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeputyRequest other = (DeputyRequest) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}




	@Override
	public String toString() {
		return "DeputyRequest [username=" + username + ", email=" + email + ", password=" + password + "]";
	}
	
	
	
	
	
	

}
