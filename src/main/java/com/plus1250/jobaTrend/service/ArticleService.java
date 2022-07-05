package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.ArticleDTO;

import java.util.List;

public interface ArticleService {
    List<ArticleDTO> selectArticle(ArticleDTO articleDTO);
}
