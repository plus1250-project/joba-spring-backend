package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(MonthRankKeywordCompositeKey.class)
@Table(name="month_rank_keyword_list")
public class MonthRankKeyword {

    @Id
    @Column(name="main_indus_name")
    private String industryName;

    @Id
    @Column(name="reg_month")
    private String regMonth;

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="keyword_count")
    private int keywordCnt;

    @Column(name="month_rank")
    private int monthRank;

    public MonthRankKeyword() {}

    public MonthRankKeyword(String industryName) {}

    @Builder
    public MonthRankKeyword(String industryName, String regMonth, String keyword, int keywordCnt, int monthRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
        this.keywordCnt = keywordCnt;
        this.monthRank = monthRank;
    }

}
