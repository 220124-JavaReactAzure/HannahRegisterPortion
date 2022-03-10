package com.revature.p2.dto;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.revature.p2.models.Deputy;

public class OffenseRequest {
	
	private String offense_description;
	
	@JsonIgnore
	private Deputy deputy;

	public String getOffense_description() {
		return offense_description;
	}

	public void setOffense_description(String offense_description) {
		this.offense_description = offense_description;
	}

	public Deputy getDeputy() {
		return deputy;
	}

	public void setDeputy(Deputy deputy) {
		this.deputy = deputy;
	}

	@Override
	public int hashCode() {
		return Objects.hash(deputy, offense_description);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OffenseRequest other = (OffenseRequest) obj;
		return Objects.equals(deputy, other.deputy) && Objects.equals(offense_description, other.offense_description);
	}

	@Override
	public String toString() {
		return "OffenseRequest [offense_description=" + offense_description + ", deputy=" + deputy + "]";
	}
	
	
	
	
	
	
	
	
	

}
