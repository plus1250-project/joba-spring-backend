package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.service.KeywordService;
import org.springframework.web.bind.annotation.RequestBody;

// 언급량 분석 / 월별트렌드 키워드 / 과거 월별 조회 / 상승 키워드
public class KeywordController {

    // 언급량 분석
    public MainKeywordDTO selectMainKeyword(@RequestBody String industryDTO) {
        // return KeywordService.selectMainKeyword(industryName);
    }

    // 월별 트렌드 분석
    public MonthlyKeywordDTO selectMonthlyKeyword(@RequestBody String industryDTO) {
        // return KeywordService.selectMonthlyKeyword(industryName);
    }

    // 과거 월별 조회
    public KeywordMonthListDTO selectKeywordMonthInfo(@RequestBody String industryDTO) {
        // return KeywordService.selectKeywordMonthInfo(industryName);
    }

    // 상승 키워드
    public IncreaseKeywordDTO selectIncreaseKeyword(@RequestBody String industryName) {
        return KeywordService.selectIncreaseKeyword(industryName);
    }
}

