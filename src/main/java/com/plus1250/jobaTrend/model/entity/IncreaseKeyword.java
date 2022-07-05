package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(IncreaseKeywordCompositeKey.class)
@Table(name="increase_keyword")
public class IncreaseKeyword {

    @Id
    @Column(name="main_indus_name")
    private String industryName;

    @Id
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
    public IncreaseKeyword(String industryName, String regMonth, String keyword) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
    }
}
