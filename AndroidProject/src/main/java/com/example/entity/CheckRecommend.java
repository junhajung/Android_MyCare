package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CHECKRECOMMEND")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_ITEM1_NO",	initialValue = 1,	allocationSize = 1) //생성될 시퀀스명
public class CheckRecommend {
	
	
	@Id
	@Column(name = "RECOMMENDID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	Long recommendid;
	
	@Column(name = "CHECKEDLIST")
	private Long checkedlist;
	
	
	@Column(name = "RECOMMENDLIST")
	private String recommendlist;

	

	public Long getRecommendid() {
		return recommendid;
	}



	public void setRecommendid(Long recommendid) {
		this.recommendid = recommendid;
	}






	public Long getCheckedlist() {
		return checkedlist;
	}



	public void setCheckedlist(Long checkedlist) {
		this.checkedlist = checkedlist;
	}



	public String getRecommendlist() {
		return recommendlist;
	}



	public void setRecommendlist(String recommendlist) {
		this.recommendlist = recommendlist;
	}



	public CheckRecommend() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	public String toString() {
		return "CheckRecommend [recommendid=" + recommendid + ", checkedlist=" + checkedlist + ", recommendlist="
				+ recommendlist + "]";
	}
	
	
	
	
	
}
