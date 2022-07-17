package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@IdClass(TrendKeywordCompositeKey.class)
@Table(name="trend_keyword_list")
public class TrendKeyword {

    @Id
    @Column(name="industry_name")
    private String industryName;

    @Id
    @Column(name="from_date")
    private Date fromDate;

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="keyword_count")
    private int keywordCnt;

    @Column(name="trend_rank")
    private int trendRank;

    public TrendKeyword() {}

    public TrendKeyword(String industryName, Date fromDate) {
        this.industryName = industryName;
        this.fromDate = fromDate;
    }

    @Builder
    public TrendKeyword(String industryName, Date fromDate, String keyword, int keywordCnt, int trendRank) {
        this.industryName = industryName;
        this.fromDate = fromDate;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.trendRank = trendRank;
    }
}
