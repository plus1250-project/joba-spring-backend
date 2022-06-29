package com.plus1250.jobaTrend.model.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Table(name="indus_corp_list")
public class IndusCorpList {

    @Id
    @Column(name="industry_name")
    private String industryName;

    @Column(name="informal_name")
    private String informalName;

    @Column(name="cnt")
    private int cnt;

}
