package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.ArticleListDTO;
import com.plus1250.jobaTrend.model.entity.ArticleList;
import com.plus1250.jobaTrend.repository.ArticleListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleListServiceImpl implements ArticleListService {

    @Autowired
    private final ArticleListRepository articleListRepository;

    @Override
    public List<ArticleListDTO> selectArticleList(ArticleListDTO articleListDTO) {
        System.out.println("serviceImpl : " + articleListDTO);

        // DB
        List<ArticleList> articleList = articleListRepository.findByIndustryName(articleListDTO.getIndustryName());

        // list entity
        List<ArticleListDTO> result = articleList.stream().map(r -> new ArticleListDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

}