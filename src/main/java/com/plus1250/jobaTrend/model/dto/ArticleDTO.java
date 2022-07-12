package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleDTO {
    private int articleId;
    private String industryName;
    private String articleUrl;
    private String issueDate;
    private String articleTitle;
    private String press;

    public ArticleDTO() {}

    public ArticleDTO(String industryName, String issueDate) {
        this.industryName = industryName;
        this.issueDate = issueDate;
    }

    public ArticleDTO(Article r) {
        this.articleId = r.getArticleId();
        this.industryName = r.getIndustryName();
        this.articleUrl = r.getArticleUrl();
        this.issueDate = r.getIssueDate();
        this.articleTitle = r.getArticleTitle();
        this.press = r.getPress();
    }

    @Builder
    public ArticleDTO(int articleId, String industryName, String articleUrl, String issueDate, String articleTitle, String press) {
        this.articleId = articleId;
        this.industryName = industryName;
        this.articleUrl = articleUrl;
        this.issueDate = issueDate;
        this.articleTitle = articleTitle;
        this.press = press;
    }
}
