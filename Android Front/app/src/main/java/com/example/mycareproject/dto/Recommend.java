package com.example.mycareproject.dto;

public class Recommend {
    private Long recommendid;
    private Long checkedlist;
    private String recommendlist;

    public Recommend(){}

    @Override
    public String toString() {
        return "Recommend{" +
                "recommendid=" + recommendid +
                ", checkedlist=" + checkedlist +
                ", recommendlist='" + recommendlist + '\'' +
                '}';
    }

    public Recommend(Long recommendid, Long checkedlist, String recommendlist) {
        this.recommendid = recommendid;
        this.checkedlist = checkedlist;
        this.recommendlist = recommendlist;
    }

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
}
