package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(MonthKeywordCompositeKey.class)
@Table(name="month_keyword_list")
public class MonthKeyword {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Id
    @Column(name="reg_month")
    private String regMonth;

    @Id
    @Column(name="main_indus_name")
    private String industryName;

    @Column(name="keyword_count")
    private int keywordCnt;

    public MonthKeyword() {}

    @Builder
    public MonthKeyword(String keyword, String regMonth, String industryName, int keywordCnt) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
        this.keywordCnt = keywordCnt;
    }
}
