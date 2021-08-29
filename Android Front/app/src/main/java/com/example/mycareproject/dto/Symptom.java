package com.example.mycareproject.dto;

public class Symptom {
    Long id;
    String symptom;
    String vitaminsearch;

    public Symptom(){}
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

    @Override
    public String toString() {
        return "Symptom{" +
                "id=" + id +
                ", symptom='" + symptom + '\'' +
                ", vitaminsearch='" + vitaminsearch + '\'' +
                '}';
    }
}
