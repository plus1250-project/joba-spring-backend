package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="increase_keyword")
public class IncreaseKeyword {

    @Id
    @Column(name="increase_id")
    private int increaseId;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="reg_month")
    private String regMonth;

    @Column(name="keyword")
    private String keyword;

    public IncreaseKeyword() {}

    public IncreaseKeyword(String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }

    @Builder
    public IncreaseKeyword(int increaseId, String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }
}
