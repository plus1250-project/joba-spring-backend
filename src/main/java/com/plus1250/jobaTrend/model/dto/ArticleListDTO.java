package com.plus1250.jobaTrend.model.dto;


import com.plus1250.jobaTrend.model.entity.ArticleList;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ArticleListDTO {
    private String articleUrl;
    private String articleTitle;
    private String pubCompany;
    private String pubDate;
    private String industryName;

    public ArticleListDTO() {}

    public ArticleListDTO(ArticleList r) {
        this.articleUrl = r.getArticleUrl();
        this.articleTitle = r.getArticleTitle();
        this.pubCompany = r.getPubCompany();
        this.pubDate = r.getPubDate();
        this.industryName = r.getIndustryName();
    }

    @Builder
    public ArticleListDTO(String articleUrl, String articleTitle, String pubCompany, String pubDate, String industryName) {
        this.articleUrl = articleUrl;
        this.articleTitle = articleTitle;
        this.pubCompany = pubCompany;
        this.pubDate = pubDate;
        this.industryName = industryName;
    }
}
