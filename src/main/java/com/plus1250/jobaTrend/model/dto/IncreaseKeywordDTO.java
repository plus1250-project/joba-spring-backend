package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;

public class IncreaseKeywordDTO {
    private String keyword;
    private String industryName;
    private String increaseValue;

    public IncreaseKeywordDTO(String keyword, String industryName, String increaseValue) {
        this.keyword = keyword;
        this.industryName = industryName;
        this.increaseValue = increaseValue;
    }

    public IncreaseKeywordDTO() {}

    public IncreaseKeywordDTO(IncreaseKeyword r) {
        this.keyword = r.getKeyword();
        this.industryName = r.getIndustryName();
        this.increaseValue = r.getIncreaseValue();
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getIncreaseValue() {
        return increaseValue;
    }

    public void setIncreaseValue(String increaseValue) {
        this.increaseValue = increaseValue;
    }
}






