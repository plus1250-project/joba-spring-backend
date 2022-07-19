package com.plus1250.jobaTrend.model.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(CompareKeywordCompositeKey.class)
@Table(name="compare_keyword_list")
public class CompareKeyword {

    @Id
    @Column(name="industry_name")
    private String industryName;

    @Id
    @Column(name="reg_month")
    private String regMonth;

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="increment")
    private int increment;

    @Column(name="change_rank")
    private int changeRank;

    @Column(name="month_rank")
    private int monthRank;

    public CompareKeyword() {}

    public CompareKeyword(String industryName) {
        this.industryName = industryName;
    }

    public CompareKeyword(String industryName, String regMonth, String keyword, int increment, int changeRank, int monthRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
        this.increment = increment;
        this.changeRank = changeRank;
        this.monthRank = monthRank;
    }
}
