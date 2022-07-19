package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.ArticleDTO;
import com.plus1250.jobaTrend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
public class ArticleController {

    @Autowired
    private final ArticleService articleService;

    // 뉴스 기사
    @GetMapping("/article")
    public List<ArticleDTO> selectArticle(@RequestParam(value = "industryName") String industryName, @RequestParam(value = "issueDate") String issueDate) {
        System.out.println("ArticleController : " + industryName + "|" + issueDate);
        return articleService.selectArticle(new ArticleDTO(industryName, issueDate));
    }
}