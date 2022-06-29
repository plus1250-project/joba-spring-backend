package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.IndusCorpList;

public class IndusCorpListDTO {
    private String industryName;
    private String informalName;
    private int cnt;

    public IndusCorpListDTO(String industryName, String informalName, int cnt) {
        this.industryName = industryName;
        this.informalName = informalName;
        this.cnt = cnt;
    }

    public IndusCorpListDTO() {}

    public IndusCorpListDTO(String industryName) {
        this.industryName = industryName;
    }

    public IndusCorpListDTO(IndusCorpList r) {
        this.industryName = r.getIndustryName();
        this.informalName = r.getInformalName();
        this.cnt = r.getCnt();
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getInformalName() {
        return informalName;
    }

    public void setInformalName(String informalName) {
        this.informalName = informalName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
