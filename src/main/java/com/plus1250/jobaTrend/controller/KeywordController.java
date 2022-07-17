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
        System.out.println("selectIncreaseKeyword : " + industryName + " | " + regMonth);
        return keywordService.selectIncreaseKeyword(new IncreaseKeywordDTO(industryName, regMonth));
    }

    // 트렌드 키워드 리스트 (issueDate 로부터서 30일 전 데이터까지 가져와야 함)
    @GetMapping("/trend-keyword/{industryName}/{fromDate}")
        public List<TrendKeywordDTO> selectTrendKeyword(@PathVariable String industryName, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate) {
        System.out.println("selectTrendKeyword : " + industryName + " | " + fromDate);
        return keywordService.selectTrendKeyword(new TrendKeywordDTO(industryName, fromDate));
    }

    // 월별 키워드 리스트 (9개) inputDate 당일 적재 데이터
    @GetMapping("/month-keyword/{keyword}/{industryName}/{inputDate}")
    public List<MonthKeywordDTO> selectMonthKeyword(@PathVariable String keyword, @PathVariable String industryName, @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date inputDate) {
        System.out.println("monthKeyword chart data : " + keyword + " | " + industryName + " | " + inputDate);
        return keywordService.selectMonthKeyword(new MonthKeywordDTO(keyword, industryName, inputDate));
    }

    // 월별 랭킹 키워드 리스트
    @GetMapping("/month-rank-keyword/{industryName}/{regMonth}")
    public List<MonthRankKeywordDTO> selectMonthRankKeyword(@PathVariable String industryName, @PathVariable String regMonth) {
        System.out.println("MonthRankKeyword : " + industryName + " | " + regMonth);
        return keywordService.selectMonthRankKeyword(new MonthRankKeywordDTO(industryName, regMonth));
    }

    // 월별 랭킹 키워드 전월 대비 분석 리스트
    @GetMapping("/compare-keyword/{industryName}/{regMonth}")
    public List<CompareKeywordDTO> selectCompareKeyword(@PathVariable String industryName, @PathVariable String regMonth) {
        System.out.println("selectCompareKeyword called!");
        return keywordService.selectCompareKeyword(new CompareKeywordDTO(industryName, regMonth));
    }

}

