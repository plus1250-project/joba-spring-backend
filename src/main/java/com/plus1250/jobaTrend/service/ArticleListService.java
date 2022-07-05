package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.ArticleListDTO;

import java.util.List;

public interface ArticleListService {
    List<ArticleListDTO> selectArticleList(ArticleListDTO articleListDTO);
}
