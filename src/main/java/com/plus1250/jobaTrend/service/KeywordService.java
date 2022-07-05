package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;

import java.util.List;


public interface KeywordService {

    // 상승 키워드
    String selectIncreaseKeyword(IncreaseKeywordDTO increaseKeywordDTO);

    // 트렌드 키워드 리스트
    List<TrendKeywordListDTO> selectTrendKeywordList(TrendKeywordListDTO trendKeywordListDTO);

    // 월별 키워드 리스트
    List<MonthKeywordDTO> selectMonthKeyword(MonthKeywordDTO monthKeywordDTO);

    // 월별 랭킹 키워드 리스트
    List<MonthRankKeywordDTO> selectMonthRankKeyword(MonthRankKeywordDTO monthRankKeywordDTO);

    // 과거 월별 조회
    List<KeywordMonthListDTO> selectKeywordMonthInfo(KeywordMonthListDTO industryName);


}

