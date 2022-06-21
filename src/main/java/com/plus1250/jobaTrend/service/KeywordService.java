package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;

import java.util.List;

public interface KeywordService {

    // 언급량 분석
//    static MainKeywordDTO selectMainKeyword(String industryName) {
//
//       return null;
//   }

    static List<MainKeywordDTO> selectMainKeyword(String industryName) {

        return selectMainKeyword(industryName);
    }

    // 월별 트렌드 분석
    static List<MonthlyKeywordDTO> selectMonthlyKeyword(String industryName) {

        return selectMonthlyKeyword(industryName);
    }

    // 과거 월별 조회
    static List<KeywordMonthListDTO> selectKeywordMonthInfo(String industryName) {

        return selectKeywordMonthInfo(industryName);
    }

    // 상승 키워드
    static List<IncreaseKeywordDTO> selectIncreaseKeyword(String industryName) {

        return selectIncreaseKeyword(industryName);
    }

}

