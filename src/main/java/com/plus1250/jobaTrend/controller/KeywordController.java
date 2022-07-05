package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.service.KeywordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 언급량 분석 / 월별트렌드 키워드 / 과거 월별 조회 / 상승 키워드
@CrossOrigin(origins="*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class KeywordController {

    private final KeywordService keywordService;

    // 상승 키워드
    @PostMapping("/increase_keyword/{keyword]")
    public List<IncreaseKeywordDTO> selectIncreaseKeyword(@RequestParam IncreaseKeywordDTO increaseKeywordDTO) {
        System.out.println("selectIncreaseKeyword called!");
        return keywordService.selectIncreaseKeyword(increaseKeywordDTO);
    }

    // 언급량 분석
    @PostMapping("/main_keyword/{keyword}")
    public List<MainKeywordDTO> selectMainKeyword(@RequestParam MainKeywordDTO industryName) {
        System.out.println("selectMainKeyword called!");
        return keywordService.selectMainKeyword(industryName);
    }

    // 월별 트렌드 분석
    @PostMapping("/monthly_keyword/{keyword}")
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(@RequestParam MonthlyKeywordDTO industryName) {
        System.out.println("selectMonthlyKeyword called!");
        return keywordService.selectMonthlyKeyword(industryName);
    }

    // 과거 월별 조회
    @PostMapping("/keyword_month_list/{keyword}{month}")
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(@RequestParam KeywordMonthListDTO industryName) {
        System.out.println("selectKeywordMonthInfo called!");
        return keywordService.selectKeywordMonthInfo(industryName);
    }


}

