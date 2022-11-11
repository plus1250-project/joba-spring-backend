package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;

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
    @Column(name="industry_name")
    private String industryName;

    @Column(name="keyword_count")
    private int keywordCnt;

    @Column(name="input_date")
    private Date inputDate;

    public MonthKeyword() {}

    public MonthKeyword(String keyword, String industryName, Date inputDate) {
        this.keyword = keyword;
        this.industryName = industryName;
        this.inputDate = inputDate;
    }

    @Builder
    public MonthKeyword(String keyword, String regMonth, String industryName, int keywordCnt, Date inputDate) {
        this.keyword = keyword;
        this.regMonth = regMonth;
        this.industryName = industryName;
        this.keywordCnt = keywordCnt;
        this.inputDate = inputDate;
    }
}
