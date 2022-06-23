package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Getter
@Table(name="keyword_month_list")
public class KeywordMonthList {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Id
    @Column(name="month_name")
    private String month;

    @Column(name="month_cnt")
    private  double moCnt;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="key_cnt")
    private double keyCnt;

    public KeywordMonthList() {}

    public KeywordMonthList(String keyword) {
        this.keyword = keyword;
    }

    @Builder
    public KeywordMonthList(String keyword, String month, String industryName, double keyCnt) {
        this.keyword = keyword;
        this.month = month;
        this.industryName = industryName;
        this.keyCnt = keyCnt;
    }
}
