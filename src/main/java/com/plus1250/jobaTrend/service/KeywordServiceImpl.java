package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    // 언급량 분석
    public MainKeywordDTO selectMainKeyword(String industryName) {
        MainKeywordDTO mainKeywordDTO = new MainKeywordDTO();

        mainKeywordDTO= keywordRepository.findByMainKeyword(industryName);
        return mainKeywordDTO;
    }

    // 월별 트렌드 분석
    public MonthlyKeywordDTO selectMonthlyKeyword(String industryName) {
        MonthlyKeywordDTO monthlyKeywordDTO = new MonthlyKeywordDTO();

        // keywordRepository.findByMonthlyKeyword(industryName);
        return monthlyKeywordDTO;
    }

    // 과거 월별 조회
    public KeywordMonthListDTO selectKeywordMonthInfo(String industryName) {
        KeywordMonthListDTO keywordMonthListDTO = new KeywordMonthListDTO();

        // keywordRepository.findByKeywordMonthList(industryName);
        return keywordMonthListDTO;
    }

    // 상승 키워드
    public IncreaseKeywordDTO selectIncreaseKeyword(String industryName) {

        // keywordRepository.findByIncreaseKeyword(industryName);
        return KeywordService.selectIncreaseKeyword(industryName);
    }
}
