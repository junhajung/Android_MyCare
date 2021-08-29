package com.example.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="CHECKLIST")
public class CheckList {
	
	@Id
	@Column(name = "CHECKID")
	Long checkid;
	

	@Column(name = "CHECKLIST")
	private String list;
	
	
	

	public CheckList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCheckid() {
		return checkid;
	}

	public void setCheckid(Long checkid) {
		this.checkid = checkid;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	
	
}
