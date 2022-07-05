package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@IdClass(ArticleCompositeKey.class)
@Table(name="indus_article_list")
public class Article {

    @Id
    @Column(name="main_indus_name")
    private String industryName;

    @Id
    @Column(name="url")
    private String articleUrl;

    @Id
    @Column(name="issue_date")
    private String issueDate;

    @Column(name="article_title")
    private String articleTitle;

    @Column(name="press")
    private String press;

    public Article() {}

    public Article(String industryName) {
        this.industryName = industryName;
    }

    @Builder
    public Article(String industryName, String articleUrl, String issueDate, String articleTitle, String press) {
        this.industryName = industryName;
        this.articleUrl = articleUrl;
        this.issueDate = issueDate;
        this.articleTitle = articleTitle;
        this.press = press;
    }
}

