package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MonthKeywordList;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MonthKeywordListDTO {
    private String keyword;
    private String regMonth;
    private String industryName;
    private int keywordCnt;

    public MonthKeywordListDTO() {}

    public MonthKeywordListDTO(String keyword, String regMonth, String industryName) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
    }

    public MonthKeywordListDTO(MonthKeywordList r) {
        this.keyword = r.getKeyword();
        this.regMonth = r.getRegMonth();
        this.industryName = r.getIndustryName();
        this.keywordCnt = r.getKeywordCnt();
    }

    @Builder
    public MonthKeywordListDTO(String keyword, String regMonth, String industryName, int keywordCnt) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
        this.keywordCnt = keywordCnt;
    }
}
