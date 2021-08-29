package com.example.mycareproject.dto;

public class CheckList {
    private Long checkid;
    private String list;

    public CheckList(Long checkid, String list) {
        this.checkid = checkid;
        this.list = list;
    }

    public CheckList(){}

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
