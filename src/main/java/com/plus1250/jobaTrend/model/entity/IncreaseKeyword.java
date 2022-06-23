package com.plus1250.jobaTrend.model.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="increase_keyword")
public class IncreaseKeyword {

    @Id
    @Column(name="keyword")
    private String keyword;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="increase_value")
    private String increaseValue;
}
