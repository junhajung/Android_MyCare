package com.example.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VITAMIN")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_VITAMIN_KATE",	initialValue = 1,	allocationSize = 1) //생성될 시퀀스명
public class Vitamin {

	@Id
	@Column(name = "VITAMINID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SEQ")
	Long vitaminid;
	
	@Column(name = "NAME", length=50)
	private String name;
	
	
	
	// byte[] => base 64 string으로 변경해서 보관할 변수
	@Transient // 컬럼생성하지 않음
	private String base64;	
	
	@Lob
	@Column(name = "IMG")
	public byte[] img;

	
	public byte[] getImg() {
		return img;
	}


	public void setImg(byte[] img) {
		this.img = img;
	}



	
	
	public String getBase64() {
		return base64;
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}





	@Column(name = "VitaminB1" )
	private Long vitaminb1;
	
	@Column(name = "VitaminB2")
	private Long vitaminb2;
	
	@Column(name = "VitaminB3")
	private Long vitaminb3;
	
	@Column(name = "VitaminB6")
	private Long vitaminb6;
	
	@Column(name = "VitaminB7")
	private Long vitaminb7;
	
	@Column(name = "VitaminB9")
	private Long vitaminb9;
	
	
	@Column(name = "VitaminC")
	private Long vitaminC;
	
	@Column(name = "VitaminD")
	private Long vitaminD;
	
	// 유산균
	@Column(name = "VitaminE")
	private Long vitaminE;
	
	// 마그네슘
	@Column(name = "magnesium")
	private Long magnesium;
	
	// 셀레늄
	@Column(name = "selenium")
	private Long selenium;
	
	// 아연
	@Column(name = "zinc")
	private Long zinc;
	
	// 칼슘
	@Column(name = "calcium")
	private Long calcium;
	
	// 철분
	@Column(name = "iron")
	private Long iron;
	
	// 유산균
	@Column(name = "bacteria")
	private Long bacteria;
	
	// 아스타잔틴
	@Column(name = "astaxanthin")
	private Long astaxanthin;
	
	// 비타민 총 17개
	
	
	@Column(name = "vitaminsearch")
	private String vitaminsearch;
	




	public String getVitaminsearch() {
		return vitaminsearch;
	}


	public void setVitaminsearch(String vitaminsearch) {
		this.vitaminsearch = vitaminsearch;
	}


	public Long getVitaminb1() {
		return vitaminb1;
	}


	public void setVitaminb1(Long vitaminb1) {
		this.vitaminb1 = vitaminb1;
	}


	public Long getVitaminb2() {
		return vitaminb2;
	}


	public void setVitaminb2(Long vitaminb2) {
		this.vitaminb2 = vitaminb2;
	}


	public Long getVitaminb3() {
		return vitaminb3;
	}


	public void setVitaminb3(Long vitaminb3) {
		this.vitaminb3 = vitaminb3;
	}


	public Long getVitaminb6() {
		return vitaminb6;
	}


	public void setVitaminb6(Long vitaminb6) {
		this.vitaminb6 = vitaminb6;
	}


	public Long getVitaminb7() {
		return vitaminb7;
	}


	public void setVitaminb7(Long vitaminb7) {
		this.vitaminb7 = vitaminb7;
	}


	public Long getVitaminb9() {
		return vitaminb9;
	}


	public void setVitaminb9(Long vitaminb9) {
		this.vitaminb9 = vitaminb9;
	}




	public Long getVitaminC() {
		return vitaminC;
	}


	public void setVitaminC(Long vitaminC) {
		this.vitaminC = vitaminC;
	}


	public Long getVitaminD() {
		return vitaminD;
	}


	public void setVitaminD(Long vitaminD) {
		this.vitaminD = vitaminD;
	}


	public Long getVitaminE() {
		return vitaminE;
	}


	public void setVitaminE(Long vitaminE) {
		this.vitaminE = vitaminE;
	}


	public Long getMagnesium() {
		return magnesium;
	}


	public void setMagnesium(Long magnesium) {
		this.magnesium = magnesium;
	}


	public Long getSelenium() {
		return selenium;
	}


	public void setSelenium(Long selenium) {
		this.selenium = selenium;
	}


	public Long getZinc() {
		return zinc;
	}


	public void setZinc(Long zinc) {
		this.zinc = zinc;
	}


	public Long getCalcium() {
		return calcium;
	}


	public void setCalcium(Long calcium) {
		this.calcium = calcium;
	}


	public Long getIron() {
		return iron;
	}


	public void setIron(Long iron) {
		this.iron = iron;
	}


	public Long getBacteria() {
		return bacteria;
	}


	public void setBacteria(Long bacteria) {
		this.bacteria = bacteria;
	}


	public Long getAstaxanthin() {
		return astaxanthin;
	}


	public void setAstaxanthin(Long astaxanthin) {
		this.astaxanthin = astaxanthin;
	}






	public Long getVitaminid() {
		return vitaminid;
	}


	public void setVitaminid(Long vitaminid) {
		this.vitaminid = vitaminid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public Vitamin() {
		super();
		// TODO Auto-generated constructor stub
	}




	
	
}
