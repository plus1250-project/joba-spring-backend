package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MonthlyKeyword;

public class MonthlyKeywordDTO {
    private String keyword;
    private String monthlyDate;
    private String industryName;
    private double keyCnt;

    public MonthlyKeywordDTO(String keyword, String monthlyDate, String industryName, double keyCnt) {
        this.keyword = keyword;
        this.monthlyDate = monthlyDate;
        this.industryName = industryName;
        this.keyCnt = keyCnt;
    }

    public MonthlyKeywordDTO() {}

    public MonthlyKeywordDTO(MonthlyKeyword r) {
        this.keyword = r.getKeyword();
        this.monthlyDate = r.getMonthlyDate();
        this.industryName = r.getIndustryName();
        this.keyCnt = r.getKeyCnt();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMonthlyDate() {
        return monthlyDate;
    }

    public void setMonthlyDate(String monthlyDate) {
        this.monthlyDate = monthlyDate;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public double getKeyCnt() {
        return keyCnt;
    }

    public void setKeyCnt(double keyCnt) {
        this.keyCnt = keyCnt;
    }
}
