package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.TrendKeyword;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class TrendKeywordDTO {
    private String industryName;
    private Date issueDate;
    private String keyword;
    private int keywordCnt;
    private int trendRank;

    public TrendKeywordDTO() {}

    public TrendKeywordDTO(String industryName, Date issueDate) {
        this.industryName = industryName;
        this.issueDate = issueDate;
    }

    public TrendKeywordDTO(TrendKeyword r) {
        this.industryName = r.getIndustryName();
        this.issueDate = r.getIssueDate();
        this.keyword = r.getKeyword();
        this.keywordCnt = r.getKeywordCnt();
        this.trendRank = r.getTrendRank();
    }

    @Builder
    public TrendKeywordDTO(String industryName, Date issueDate, String keyword, int keywordCnt, int trendRank) {
        this.industryName = industryName;
        this.issueDate = issueDate;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.trendRank = trendRank;
    }
}