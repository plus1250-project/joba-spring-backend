package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.ArticleDTO;
import com.plus1250.jobaTrend.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/")
@RequiredArgsConstructor
@RestController
public class ArticleController {

    @Autowired
    private final ArticleService articleService;

    // 뉴스 기사 컨트롤러 test
    @GetMapping("/article")
    public List<ArticleDTO> selectArticle(@RequestParam ArticleDTO articleDTO) {
        System.out.println("controller : " + articleDTO);
        return articleService.selectArticle(articleDTO);
    }
}
