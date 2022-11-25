package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.ArticleDTO;
import com.plus1250.jobaTrend.model.entity.Article;
import com.plus1250.jobaTrend.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;


    @Override
    public List<ArticleDTO> selectArticle(ArticleDTO articleDTO) {
        List<Article> articles = articleRepository.findByIndustryNameAndIssueDate(articleDTO.getIndustryName(), articleDTO.getIssueDate());
        List<ArticleDTO> result = articles.stream().map(r -> new ArticleDTO(r)).collect(Collectors.toList());

        return result;
    }

}
