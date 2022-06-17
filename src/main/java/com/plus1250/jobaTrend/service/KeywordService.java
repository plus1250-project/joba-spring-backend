package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.repository.KeywordRepository;

public interface KeywordService {

    // 언급량 분석
//    static MainKeywordDTO selectMainKeyword(String industryDTO) {
//
//       return null;
//   }

    static MainKeywordDTO selectMainKeyword(String industryDTO) {
        return null;
    }

    // 월별 트렌드 분석
    static MonthlyKeywordDTO selectMonthlyKeyword(String industryDTO) {

        return null;
    }

    // 과거 월별 조회
    static KeywordMonthListDTO selectKeywordMonthInfo(String industryName) {

        return null;
    }

    // 상승 키워드
    static IncreaseKeywordDTO selectIncreaseKeyword(String industryName) {

        return null;
    }
}

