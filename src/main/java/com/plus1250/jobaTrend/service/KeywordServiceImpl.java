package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    // 언급량 분석
    public List<MainKeywordDTO> selectMainKeyword(String industryName) {
        List<MainKeywordDTO> mainKeywordDTO  = keywordRepository.findByMainKeyword(industryName);

        return KeywordService.selectMainKeyword(industryName);
    }

    // 월별 트렌드 분석
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(String industryName) {
        List<MonthlyKeywordDTO> monthlyKeywordDTO = keywordRepository.findByMonthlyKeyword(industryName);

        return KeywordService.selectMonthlyKeyword(industryName);

    }
//    public MonthlyKeywordDTO selectMonthlyKeyword(String industryName) {
//        MonthlyKeywordDTO monthlyKeywordDTO = new MonthlyKeywordDTO();
//
//        monthlyKeywordDTO = keywordRepository.findByMonthlyKeyword(industryName);
//        return monthlyKeywordDTO;
//    }

    // 과거 월별 조회
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(String industryName) {
        List<KeywordMonthListDTO> keywordMonthListDTO = keywordRepository.findByKeywordMonthList(industryName);

        return KeywordService.selectKeywordMonthInfo(industryName);
    }

    // 상승 키워드
    public List<IncreaseKeywordDTO> selectIncreaseKeyword(String industryName) {
        List<IncreaseKeywordDTO> increaseKeywordDTO = keywordRepository.findByIncreaseKeyword(industryName);

        return KeywordService.selectIncreaseKeyword(industryName);
    }
}
