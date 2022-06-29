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


//   @Override
//    public List<ArticleListDTO> selectArticleInfo(String industryName) {
//        return null;
//   }

    @Override
    public List<ArticleListDTO> selectArticleInfo(ArticleListDTO articleListDTO) {
        System.out.println("serviceImpl : " + articleListDTO);

        // DB
        List<ArticleList> articleList = articleListRepository.findByIndustryName(articleListDTO.getIndustryName());

//        ArticleList result = articleList.get(0);
//        System.out.println(result);


        // DTO 하나일 경우
//        ArticleListDTO aListDTO = new ArticleListDTO();

//        aListDTO.setArticleUrl(articleList.getArticleUrl());
//        aListDTO.setIndustryName(articleList.getIndustryName());
//        aListDTO.setArticleTitle(articleList.getArticleTitle());
//        aListDTO.setPubCompany(articleList.getPubCompany());
//        aListDTO.setPubDate(articleList.getPubDate());
//
//        ArticleListDTO aListDTO = ArticleListDTO.builder().
//                industryName(result.getIndustryName()).articleTitle(result.getArticleTitle()).build();

        // list entity
        List<ArticleListDTO> result = articleList.stream().map(r -> new ArticleListDTO(r)).collect(Collectors.toList());
        System.out.println(result);
        return result;
    }

}
