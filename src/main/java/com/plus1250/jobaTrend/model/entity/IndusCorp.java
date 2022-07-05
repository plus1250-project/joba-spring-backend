package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(IndusCorpCompositeKey.class)
@Table(name="indus_corp_list")
public class IndusCorp {

    @Id
    @Column(name="industry_name")
    private String industryName;

    @Id
    @Column(name="reg_month")
    private String regMonth;

    @Id
    @Column(name="corp_name")
    private String corpName;

    @Column(name="corp_rank")
    private int corpRank;

    public IndusCorp() {}

    public IndusCorp(String industryName) {
        this.industryName = industryName;
    }

    @Builder
    public IndusCorp(String industryName, String regMonth, String corpName, int corpRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.corpName = corpName;
        this.corpRank = corpRank;
    }
}
