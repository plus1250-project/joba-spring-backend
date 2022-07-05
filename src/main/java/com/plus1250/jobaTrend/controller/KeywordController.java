package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

// 언급량 분석 / 월별트렌드 키워드 / 과거 월별 조회 / 상승 키워드
@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class KeywordController {

    @Autowired
    private final KeywordService keywordService;

    // 상승 키워드
    @GetMapping("/increase-keyword/{industryName}/{regMonth}")
    public String selectIncreaseKeyword(@PathVariable String industryName, @PathVariable String regMonth) {
        System.out.println("selectIncreaseKeyword called!");
        return keywordService.selectIncreaseKeyword(new IncreaseKeywordDTO(industryName, regMonth));
    }

    // 트렌드 키워드 리스트 (issueDate 로부터서 30일 전 데이터까지 가져와야 함)
    @GetMapping("/trend-keyword/{industryName}/{issueDate}")
    public List<TrendKeywordDTO> selectTrendKeyword(@PathVariable String industryName, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date issueDate) {
        return keywordService.selectTrendKeyword(new TrendKeywordDTO(industryName, issueDate));
    }

    // 월별 키워드 리스트
    @PostMapping("/month_keyword/{keyword}")
    public List<MonthKeywordDTO> selectMonthKeyword(@RequestParam MonthKeywordDTO monthKeywordDTO) {
        System.out.println("selectMonthKeyword called!");
        return keywordService.selectMonthKeyword(monthKeywordDTO);
    }

    // 월별 랭킹 키워드 리스트
    @PostMapping("/month_rank_keyword/{keyword}")
    public List<MonthRankKeywordDTO> selectMonthRankKeyword(@RequestParam MonthRankKeywordDTO monthRankKeywordDTO) {
        System.out.println("selectMonthKeyword called!");
        return keywordService.selectMonthRankKeyword(monthRankKeywordDTO);
    }

    // 월별 랭킹 키워드 전월 대비 분석 리스트
    @PostMapping("/compare_keyword/{keyword}")
    public List<CompareKeywordDTO> selectCompareKeyword(@RequestParam CompareKeywordDTO compareKeywordDTO) {
        System.out.println("selectCompareKeyword called!");
        return keywordService.selectCompareKeyword(compareKeywordDTO);
    }

}

