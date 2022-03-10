package com.revature.p2.dto;

import java.util.Objects;

import com.revature.p2.models.Offense;

public class OffenseResponse {
	
	private int id;
	private String offense_description;
	private DeputyResponse deputyInfo;
	
	
	public OffenseResponse() {
		super();
	}
	
	
	public OffenseResponse(Offense offense) {
		this.id = offense.getId();
		this.offense_description = offense.getOffense_description();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getOffense_description() {
		return offense_description;
	}


	public void setOffense_description(String offense_description) {
		this.offense_description = offense_description;
	}


	public DeputyResponse getDeputyInfo() {
		return deputyInfo;
	}


	public void setDeputyInfo(DeputyResponse deputyInfo) {
		this.deputyInfo = deputyInfo;
	}


	@Override
	public String toString() {
		return "OffenseResponse [id=" + id + ", offense_description=" + offense_description + ", deputyInfo="
				+ deputyInfo + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(deputyInfo, id, offense_description);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OffenseResponse other = (OffenseResponse) obj;
		return Objects.equals(deputyInfo, other.deputyInfo) && id == other.id
				&& Objects.equals(offense_description, other.offense_description);
	}
	
	
	
	
	
	
	
	

}
