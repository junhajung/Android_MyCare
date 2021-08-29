package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="SYMPTOM")
public class Symptom {
	
	@Id
	@Column(name = "SYMPTOMID")
	Long id;
	
	@Column(name = "SYMPTOM")
	private String symptom;
	
	@Column (name = "VITAMINSEARCH")
    private String vitaminsearch;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSymptom() {
		return symptom;
	}

	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	public String getVitaminsearch() {
		return vitaminsearch;
	}

	public void setVitaminsearch(String vitaminsearch) {
		this.vitaminsearch = vitaminsearch;
	}


	
	
	
	

}
