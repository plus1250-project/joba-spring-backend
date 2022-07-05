package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.ArticleList;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ArticleListDTO {
    private String industryName;
    private String articleUrl;
    private String issueDate;
    private String articleTitle;
    private String press;

    public ArticleListDTO() {}

    public ArticleListDTO(String industryName) {
        this.industryName = industryName;
    }

    public ArticleListDTO(ArticleList r) {

    }

    @Builder
    public ArticleListDTO(String industryName, String articleUrl, String issueDate, String articleTitle, String press) {
        this.industryName = industryName;
        this.articleUrl = articleUrl;
        this.issueDate = issueDate;
        this.articleTitle = articleTitle;
        this.press = press;
    }
}
