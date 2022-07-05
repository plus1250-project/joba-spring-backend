package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(IndusCorpListCompositeKey.class)
@Table(name="indus_corp_list")
public class IndusCorpList {

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

    public IndusCorpList() {}

    public IndusCorpList(String industryName) {
        this.industryName = industryName;
    }

    @Builder
    public IndusCorpList(String industryName, String regMonth, String corpName, int corpRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.corpName = corpName;
        this.corpRank = corpRank;
    }
}
