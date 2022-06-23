package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import com.plus1250.jobaTrend.model.entity.MonthlyKeyword;

public class KeywordMonthListDTO {
    private String keyword;
    private String month;
    private double moCnt;
    private String industryName;
    private double keyCnt;

    public KeywordMonthListDTO(String keyword, String month, double moCnt, String industryName, double keyCnt) {
        this.keyword = keyword;
        this.month = month;
        this.moCnt = moCnt;
        this.industryName = industryName;
        this.keyCnt = keyCnt;
    }

    public KeywordMonthListDTO() {}

    public KeywordMonthListDTO(KeywordMonthList r) {
        this.keyword = r.getKeyword();
        this.month = r.getMonth();
        this.moCnt = r.getMoCnt();
        this.industryName = r.getIndustryName();
        this.keyCnt = r.getKeyCnt();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getMoCnt() {
        return moCnt;
    }

    public void setMoCnt(double moCnt) {
        this.moCnt = moCnt;
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
