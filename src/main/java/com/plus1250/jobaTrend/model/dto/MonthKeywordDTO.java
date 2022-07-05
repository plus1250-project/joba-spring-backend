package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MonthKeyword;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MonthKeywordDTO {
    private String keyword;
    private String regMonth;
    private String industryName;
    private int keywordCnt;

    public MonthKeywordDTO() {}

    public MonthKeywordDTO(String keyword, String regMonth, String industryName) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
    }

    public MonthKeywordDTO(MonthKeyword r) {
        this.keyword = r.getKeyword();
        this.regMonth = r.getRegMonth();
        this.industryName = r.getIndustryName();
        this.keywordCnt = r.getKeywordCnt();
    }

    @Builder
    public MonthKeywordDTO(String keyword, String regMonth, String industryName, int keywordCnt) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
        this.keywordCnt = keywordCnt;
    }
}
