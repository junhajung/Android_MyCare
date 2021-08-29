package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VITAMINMEMBER" )
public class Member {
	
	@Id
	@Column(name = "MEMID", length=20)
	private String id;


	@Column(name = "MEMPW", length=200)
	private String pw;
	
	@Column(name = "MEMNAME", length=20)
	private String name;
	
	


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
