package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.ArticleList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleListRepository extends JpaRepository<ArticleList, String> {

    List<ArticleList> findByIndustryName(String industryName);
}
