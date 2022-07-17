package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MonthKeyword;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class MonthKeywordDTO {
    private String keyword;
    private String regMonth;
    private String industryName;
    private int keywordCnt;
    private Date inputDate;

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
        this.inputDate = r.getInputDate();
    }

    @Builder
    public MonthKeywordDTO(String keyword, String regMonth, String industryName, int keywordCnt, Date inputDate) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
        this.keywordCnt = keywordCnt;
        this.inputDate = inputDate;
    }
}
