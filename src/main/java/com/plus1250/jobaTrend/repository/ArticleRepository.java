package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, String> {

    List<Article> findByIndustryName(String industryName);
}
