package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="VITAMINDAY")
public class VitaminDay {
	
	
	@Id
	@Column(name = "VITAMINDAY")
	String vitamin;
	
	@Column(name = "VITAMINMAXNUM" )
	private Double maxnum;
	
	@Column(name = "VITAMINMINNUM" )
	private Double minnum;
	
	
	

	public String getVitamin() {
		return vitamin;
	}

	public void setVitamin(String vitamin) {
		this.vitamin = vitamin;
	}

	



	

	public Double getMaxnum() {
		return maxnum;
	}

	public void setMaxnum(Double maxnum) {
		this.maxnum = maxnum;
	}

	public Double getMinnum() {
		return minnum;
	}

	public void setMinnum(Double minnum) {
		this.minnum = minnum;
	}

	public VitaminDay() {
		super();
	}
	
	
	
}
