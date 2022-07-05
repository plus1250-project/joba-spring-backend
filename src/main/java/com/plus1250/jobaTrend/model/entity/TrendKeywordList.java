package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@IdClass(TrendKeywordListCompositeKey.class)
@Table(name="trend_keyword_list")
public class TrendKeywordList {

    @Id
    @Column(name="main_indus_name")
    private String industryName;

    @Id
    @Column(name="issue_date")
    private Date issueDate;

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="keyword_count")
    private int keywordCnt;

    @Column(name="trend_rank")
    private int trendRank;

    public TrendKeywordList() {}

    public TrendKeywordList(String industryName) {}

    @Builder
    public TrendKeywordList(String industryName, Date issueDate, String keyword, int keywordCnt, int trendRank) {
        this.industryName = industryName;
        this.issueDate = issueDate;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.trendRank = trendRank;
    }
}
