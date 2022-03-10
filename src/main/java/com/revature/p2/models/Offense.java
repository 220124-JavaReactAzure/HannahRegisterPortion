package com.revature.p2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "offenses")
@JsonIdentityInfo( // This helps with he serialization to stop recursion with hibernate joins
		generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")

public class Offense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "offense_id", unique = true)
	private int id;


	@Column(name = "offense_description", unique = false, nullable = false)
	private String offense_description;
	
	@ManyToOne
	@JoinColumn(name = "offender_id")
	private Offender offender;
	
	
	
	public Offense() {}

	
	public Offense(int id, String offense_description) {
		super();
		this.id = id;
		this.offense_description = offense_description;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Offender getOffender() {
		return offender;
	}

	public void setOffender(Offender offender) {
		this.offender = offender;
	}

	public String getOffense_description() {
		return offense_description;
	}

	public void setOffense_description(String offense_description) {
		this.offense_description = offense_description;
	}
	
	
	
	
	

}
