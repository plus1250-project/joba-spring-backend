package com.plus1250.jobaTrend.model.entity;


import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(GrowthCorpCompositeKey.class)
@Table(name="growth_corp_list")
public class GrowthCorp {

    @Id
    @Column(name="industry_name")
    private String industryName;

    @Id
    @Column(name="reg_month")
    private String regMonth;

    @Id
    @Column(name="corp_name")
    private String corpName;

    @Column(name="growth_rate")
    private float growthRate;

    @Column(name="corp_rank")
    private int corpRank;


}
