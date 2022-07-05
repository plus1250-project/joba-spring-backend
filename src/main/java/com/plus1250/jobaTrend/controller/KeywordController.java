package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    @GetMapping("/increase_keyword/{keyword}")
    public String selectIncreaseKeyword(@RequestParam IncreaseKeywordDTO increaseKeywordDTO) {
        System.out.println("selectIncreaseKeyword called!");
        return keywordService.selectIncreaseKeyword(increaseKeywordDTO);
    }

    // 트렌드 키워드 리스트
    @PostMapping("/trend_keyword/{keyword}")
    public List<TrendKeywordDTO> selectTrendKeyword(@RequestParam TrendKeywordDTO trendKeywordDTO) {
        System.out.println("selectTrendKeyword called!");
        return keywordService.selectTrendKeyword(trendKeywordDTO);
    }

    // 월별 키워드 리스트
    @PostMapping("/month_keyword/{keyword}")
    public List<MonthKeywordDTO> selectMonthKeyword(@RequestParam MonthKeywordDTO monthKeywordDTO) {
        System.out.println("selectMonthKeyword called!");
        return keywordService.selectMonthKeyword(monthKeywordDTO);
    }

    // 월별 키워드 리스트
    @PostMapping("/month_keyword/{keyword}")
    public List<MonthRankKeywordDTO> selectMonthRankKeywordList(@RequestParam MonthRankKeywordDTO monthRankKeywordDTO) {
        System.out.println("selectMonthKeyword called!");
        return keywordService.selectMonthRankKeyword(monthRankKeywordDTO);
    }

    // 과거 월별 조회
    @PostMapping("/keyword_month_list/{keyword}{month}")
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(@RequestParam KeywordMonthListDTO industryName) {
        System.out.println("selectKeywordMonthInfo called!");
        return keywordService.selectKeywordMonthInfo(industryName);
    }


}

