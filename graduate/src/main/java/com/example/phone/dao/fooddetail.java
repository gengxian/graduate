package com.example.phone.dao;

import java.util.Date;

public class fooddetail {
    private String food;
    private String foodtype;
    private String urlpath;
    private String description;
    private String belong;
    private Date createtime;
    private String opcreate;
    private Double oprecommend;
    private Integer sumfoodtype;

    public Integer getSumfoodtype() {
        return sumfoodtype;
    }

    public void setSumfoodtype(Integer sumfoodtype) {
        this.sumfoodtype = sumfoodtype;
    }

    public Double getOprecommend() {
        return oprecommend;
    }

    public void setOprecommend(Double oprecommend) {
        this.oprecommend = oprecommend;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getUrlpath() {
        return urlpath;
    }

    public void setUrlpath(String urlpath) {
        this.urlpath = urlpath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getOpcreate() {
        return opcreate;
    }

    public void setOpcreate(String opcreate) {
        this.opcreate = opcreate;
    }

    public fooddetail(String food) {
        this.food = food;
    }

}
