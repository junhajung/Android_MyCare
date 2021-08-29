package com.example.mycareproject.dto;

import android.widget.ImageView;

import java.util.Arrays;

public class Vitamin {
    private Long vitaminid;
    private String name;
    private Long vitaminb1;
    private Long vitaminb2;
    private Long vitaminb3;
    private Long vitaminb6;
    private Long vitaminb7;
    private Long vitaminb9;
    private Long vitaminC;
    private Long vitaminD;
    private Long vitaminE;
    private Long magnesium;
    private Long selenium;
    private Long zinc;
    private Long calcium;
    private Long iron;
    private Long bacteria;
    private Long astaxanthin;

    public Vitamin(){}

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

    @Override
    public String toString() {
        return "Vitamin{" +
                "vitaminid=" + vitaminid +
                ", name='" + name + '\'' +
                ", vitaminb1=" + vitaminb1 +
                ", vitaminb2=" + vitaminb2 +
                ", vitaminb3=" + vitaminb3 +
                ", vitaminb6=" + vitaminb6 +
                ", vitaminb7=" + vitaminb7 +
                ", vitaminb9=" + vitaminb9 +
                ", vitaminC=" + vitaminC +
                ", vitaminD=" + vitaminD +
                ", vitaminE=" + vitaminE +
                ", magnesium=" + magnesium +
                ", selenium=" + selenium +
                ", zinc=" + zinc +
                ", calcium=" + calcium +
                ", iron=" + iron +
                ", bacteria=" + bacteria +
                ", astaxanthin=" + astaxanthin +
                '}';
    }
}
