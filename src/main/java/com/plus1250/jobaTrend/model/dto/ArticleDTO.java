package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.Article;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleDTO {
    private String industryName;
    private String articleUrl;
    private String issueDate;
    private String articleTitle;
    private String press;

    public ArticleDTO() {}

    public ArticleDTO(String industryName) {
        this.industryName = industryName;
    }

    public ArticleDTO(Article r) {

    }

    @Builder
    public ArticleDTO(String industryName, String articleUrl, String issueDate, String articleTitle, String press) {
        this.industryName = industryName;
        this.articleUrl = articleUrl;
        this.issueDate = issueDate;
        this.articleTitle = articleTitle;
        this.press = press;
    }
}
