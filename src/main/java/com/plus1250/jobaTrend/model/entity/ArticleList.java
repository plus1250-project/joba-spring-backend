package com.plus1250.jobaTrend.model.entity;


import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Table(name="Article_list")
public class ArticleList {

    @Id
    @Column(name="url")
    private String articleUrl;

    @Column(name="title")
    private String articleTitle;

    @Column(name="press_company")
    private String pubCompany;

    @Column(name="date")
    private String pubDate;

    @Column(name="industry_name")
    private String industryName;

    public ArticleList() {}

    public ArticleList(String industryName) {
        this.industryName = industryName;
    }

    @Builder
    public ArticleList(String industryName, String title) {
        this.industryName = industryName;
        this.articleTitle = title;
    }
}
