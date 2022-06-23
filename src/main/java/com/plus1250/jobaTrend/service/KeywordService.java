package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;

import java.util.List;


public interface KeywordService {

    // 언급량 분석
    List<MainKeywordDTO> selectMainKeyword(String industryName);

    // 월별 트렌드 분석
    List<MonthlyKeywordDTO> selectMonthlyKeyword(String industryName);

    // 과거 월별 조회
    List<KeywordMonthListDTO> selectKeywordMonthInfo(String industryName);

    // 상승 키워드
    List<IncreaseKeywordDTO> selectIncreaseKeyword(String industryName);
}

