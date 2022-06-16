package com.plus1250.jobaTrend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="keyword_month_list")
public class KeywordMonthList {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Id
    @Column(name="month(yy_mm)")
    private String month;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="key_cnt")
    private double keyCnt;
}
