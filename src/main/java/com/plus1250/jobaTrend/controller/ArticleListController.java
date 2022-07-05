package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.ArticleListDTO;
import com.plus1250.jobaTrend.service.ArticleListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class ArticleListController {

    @Autowired
    private final ArticleListService articleListService;

    // 뉴스 기사 컨트롤러 test
    @GetMapping("/article")
    public List<ArticleListDTO> selectArticleInfo(@RequestParam ArticleListDTO articleListDTO) {
        System.out.println("controller : " + articleListDTO);
        return articleListService.selectArticleInfo(articleListDTO);
    }
}
