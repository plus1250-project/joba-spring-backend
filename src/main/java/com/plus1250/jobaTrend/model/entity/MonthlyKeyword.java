package com.plus1250.jobaTrend.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="monthly_keyword")
public class MonthlyKeyword {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="monthly_date")
    private String monthlyDate;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="key_cnt")
    private double keyCnt;
}
