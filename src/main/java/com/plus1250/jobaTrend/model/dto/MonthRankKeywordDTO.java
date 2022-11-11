package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.MonthRankKeyword;
import lombok.Builder;
import lombok.Getter;

@Getter
public class MonthRankKeywordDTO {
    private String industryName;
    private String regMonth;
    private String keyword;
    private int keywordCnt;
    private int monthRank;

    public MonthRankKeywordDTO() {}

    public MonthRankKeywordDTO(String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }

    public MonthRankKeywordDTO(MonthRankKeyword r) {
        this.industryName = r.getIndustryName();
        this.regMonth = r.getRegMonth();
        this.keyword = r.getKeyword();
        this.keywordCnt = r.getKeywordCnt();
        this.monthRank = r.getMonthRank();
    }

    @Builder
    public MonthRankKeywordDTO(String industryName, String regMonth, String keyword, int keywordCnt, int monthRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.monthRank = monthRank;
    }
}
