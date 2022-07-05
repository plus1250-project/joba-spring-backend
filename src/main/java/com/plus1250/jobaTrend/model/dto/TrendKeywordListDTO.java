package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.TrendKeywordList;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
public class TrendKeywordListDTO {
    private String industryName;
    private Date issueDate;
    private String keyword;
    private int keywordCnt;
    private int trendRank;

    public TrendKeywordListDTO() {}

    public TrendKeywordListDTO(String industryName, Date issueDate) {
        this.industryName = industryName;
        this.issueDate = issueDate;
    }

    public TrendKeywordListDTO(TrendKeywordList r) {
        this.industryName = r.getIndustryName();
        this.issueDate = r.getIssueDate();
        this.keyword = r.getKeyword();
        this.keywordCnt = r.getKeywordCnt();
        this.trendRank = r.getTrendRank();
    }

    @Builder
    public TrendKeywordListDTO(String industryName, Date issueDate, String keyword, int keywordCnt, int trendRank) {
        this.industryName = industryName;
        this.issueDate = issueDate;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.trendRank = trendRank;
    }
}