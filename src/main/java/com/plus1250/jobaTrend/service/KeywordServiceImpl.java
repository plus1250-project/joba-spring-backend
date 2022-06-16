package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;

public class KeywordServiceImpl implements KeywordService {

    // 언급량 분석
    public MainKeywordDTO selectMainKeyword(String industryDTO) {
        MainKeywordDTO mainKeywordDTO = new MainKeywordDTO();

        // db
        // keywordRepository.findByMainKeyword(industryDTO);
        return mainKeywordDTO;
    }

    // 월별 트렌드 분석
    public MonthlyKeywordDTO selectMonthlyKeyword(String industryName {
        MonthlyKeywordDTO monthlyKeywordDTO = new MonthlyKeywordDTO();

        // d
        // keywordRepository.findByMonthlyword(industryDTO);
        return monthlyKeywordDTO;
    }

    // 과거 월별 조회
    public KeywordMonthListDTO selectKeywordMonthInfo(String industryName) {
        KeywordMonthListDTO keywordMonthListDTO = new KeywordMonthListDTO();

        // db
        // keywordRepository.findByKeywordMonthList(industryDTO);
        return keywordMonthListDTO;
    }

    // 상승 키워드
    public IncreaseKeywordDTO selectIncreaseKeyword(String industryName) {
        return KeywordService.selectIncreaseKeyword(industryName);
    }
}
