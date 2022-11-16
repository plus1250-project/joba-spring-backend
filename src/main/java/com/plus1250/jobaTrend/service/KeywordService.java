package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;

import java.util.List;

public interface KeywordService {
    // 상승 키워드
    String selectIncreaseKeyword(IncreaseKeywordDTO increaseKeywordDTO);

    // 트렌드 키워드 리스트
    List<TrendKeywordDTO> selectTrendKeyword(TrendKeywordDTO trendKeywordDTO);

    // 월별 키워드 리스트
    List<MonthKeywordDTO> selectMonthKeyword(MonthKeywordDTO monthKeywordDTO);

    // 월별 랭킹 키워드 리스트
    List<MonthRankKeywordDTO> selectMonthRankKeyword(MonthRankKeywordDTO monthRankKeywordDTO);

    // 월별 랭킹 키워드 전원 대비 분석 리스트
    List<CompareKeywordDTO> selectCompareKeyword(CompareKeywordDTO compareKeywordDTO);
}
