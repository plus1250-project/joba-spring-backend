package com.plus1250.jobaTrend.model.entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
@Table(name="industry_article_list")
public class Article {

    @Id
    @Column(name="article_id")
    private int articleId;

    @Column(name="industry_name")
    private String industryName;

    @Column(name="url")
    private String articleUrl;

    @Column(name="issue_date")
    private String issueDate;

    @Column(name="article_title")
    private String articleTitle;

    @Column(name="press")
    private String press;

    public Article() {}

    @Builder
    public Article(int articleId, String industryName, String articleUrl, String issueDate, String articleTitle, String press) {
        this.articleId = articleId;
        this.industryName = industryName;
        this.articleUrl = articleUrl;
        this.issueDate = issueDate;
        this.articleTitle = articleTitle;
        this.press = press;
    }
}
