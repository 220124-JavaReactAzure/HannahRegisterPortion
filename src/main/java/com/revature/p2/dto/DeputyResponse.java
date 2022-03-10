package com.revature.p2.dto;

import java.util.Objects;

import com.revature.p2.models.Deputy;

public class DeputyResponse {
	
	private int id;
	private String username;
	private String email;
	private String password;
	
	public DeputyResponse() {
		super();
	}
	
	public DeputyResponse(Deputy deputy) {
		this.id = deputy.getId();
		this.username = deputy.getUsername();
		this.email = deputy.getEmail();
		this.password = deputy.getPassword();

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
	public String toString() {
		return "DeputyResponse [id=" + id + ", username=" + username + ", email=" + email + ", password=" + password
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, id, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DeputyResponse other = (DeputyResponse) obj;
		return Objects.equals(email, other.email) && id == other.id && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}
	
	


	
	
	
	
	

}
