package com.plus1250.jobaTrend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="main_keyword")
public class MainKeyword {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Id
    @Column(name="daily_date")
    private String dailyDate;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="corp_name")
    private String corpName;

    @Column(name="key_cnt")
    private double keyCnt;
}
