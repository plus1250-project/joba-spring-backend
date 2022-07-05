package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.TrendKeywordListDTO;
import com.plus1250.jobaTrend.model.dto.MonthKeywordListDTO;

import java.util.List;


public interface KeywordService {

    // 상승 키워드
    String selectIncreaseKeyword(IncreaseKeywordDTO increaseKeywordDTO);

    // 트렌드 키워드 리스트
    List<TrendKeywordListDTO> selectTrendKeywordList(TrendKeywordListDTO trendKeywordListDTO);

    // 월별 키워드 리스트
    List<MonthKeywordListDTO> selectMonthKeywordList(MonthKeywordListDTO monthKeywordListDTO);

    // 과거 월별 조회
    List<KeywordMonthListDTO> selectKeywordMonthInfo(KeywordMonthListDTO industryName);


}

