package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.TrendKeyword;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class TrendKeywordDTO {
    private String industryName;
    private Date fromDate;
    private String keyword;
    private int keywordCnt;
    private int trendRank;

    public TrendKeywordDTO() {}

    public TrendKeywordDTO(String industryName, Date fromDate) {
        this.industryName = industryName;
        this.fromDate = fromDate;
    }

    public TrendKeywordDTO(TrendKeyword r) {
        this.industryName = r.getIndustryName();
        this.fromDate = r.getFromDate();
        this.keyword = r.getKeyword();
        this.keywordCnt = r.getKeywordCnt();
        this.trendRank = r.getTrendRank();
    }

    @Builder
    public TrendKeywordDTO(String industryName, Date fromDate, String keyword, int keywordCnt, int trendRank) {
        this.industryName = industryName;
        this.fromDate = fromDate;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.trendRank = trendRank;
    }
}