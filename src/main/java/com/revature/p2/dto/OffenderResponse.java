package com.revature.p2.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revature.p2.models.Deputy;
import com.revature.p2.models.Offender;

public class OffenderResponse {
	private int id;
	private String src;
	private String fullname;
	private String alias;
	private String dob;
	private String sex;
	private String height;
	private String weight;
	private String eyes;
	private String hair;
	private int orderBy;
	private DeputyResponse deputyInfo;
	


	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getEyes() {
		return eyes;
	}

	public void setEyes(String eyes) {
		this.eyes = eyes;
	}

	public String getHair() {
		return hair;
	}

	public void setHair(String hair) {
		this.hair = hair;
	}

	@Override
	public String toString() {
		return "OffenderResponse [id=" + id + ", src=" + src + ", fullname=" + fullname + ", alias=" + alias + ", dob="
				+ dob + ", sex=" + sex + ", height=" + height + ", weight=" + weight + ", eyes=" + eyes + ", hair="
				+ hair + ", deputyInfo=" + deputyInfo + "]";
	}
	
	


	
	
	


}
