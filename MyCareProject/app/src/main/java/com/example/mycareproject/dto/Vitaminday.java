package com.example.mycareproject.dto;

public class Vitaminday {
    String vitamin;
    Double maxnum;
    Double minnum;

    public Vitaminday(){};

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

    @Override
    public String toString() {
        return "Vitaminday{" +
                "vitamin='" + vitamin + '\'' +
                ", maxnum=" + maxnum +
                ", minnum=" + minnum +
                '}';
    }
}
