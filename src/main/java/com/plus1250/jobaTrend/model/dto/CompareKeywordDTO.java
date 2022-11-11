package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.CompareKeyword;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CompareKeywordDTO {
    private String industryName;
    private String regMonth;
    private String keyword;
    private int increment;
    private int changeRank;
    private int monthRank;


    public CompareKeywordDTO() {}

    public CompareKeywordDTO(String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }

    public CompareKeywordDTO(CompareKeyword r) {
        this.industryName = r.getIndustryName();
        this.regMonth = r.getRegMonth();
        this.keyword = r.getKeyword();
        this.increment = r.getIncrement();
        this.changeRank = r.getChangeRank();
        this.monthRank = r.getMonthRank();
    }

    @Builder
    public CompareKeywordDTO(String industryName, String regMonth, String keyword, int increment, int changeRank, int monthRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
        this.increment = increment;
        this.changeRank = changeRank;
        this.monthRank = monthRank;
    }
}
