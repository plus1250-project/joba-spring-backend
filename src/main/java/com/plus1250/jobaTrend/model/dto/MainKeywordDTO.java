package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MainKeyword;

public class MainKeywordDTO<S> {
    private String keyword;
    private String dailyDate;
    private String industryName;
    private String corpName;
    private double keyCnt;

    public MainKeywordDTO(String keyword, String dailyDate, String industryName, String corpName, double keyCnt) {
        this.keyword = keyword;
        this.dailyDate = dailyDate;
        this.industryName = industryName;
        this.corpName = corpName;
        this.keyCnt = keyCnt;
    }

    public MainKeywordDTO() {}



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDailyDate() {
        return dailyDate;
    }

    public void setDailyDate(String dailyDate) {
        this.dailyDate = dailyDate;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public double getKeyCnt() {
        return keyCnt;
    }

    public void setKeyCnt(double keyCnt) {
        this.keyCnt = keyCnt;
    }
}
