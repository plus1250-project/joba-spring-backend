package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import com.plus1250.jobaTrend.model.entity.MainKeyword;
import com.plus1250.jobaTrend.repository.KeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private KeywordRepository keywordRepository;

    // 언급량 분석
    @Override
    public List<MainKeywordDTO> selectMainKeyword(String industryName) {
        List<MainKeywordDTO> mainKeywordDTO  = keywordRepository.findByMainKeyword(industryName);

        System.out.println("" + industryName);

        return mainKeywordDTO;
    }

    // 월별 트렌드 분석
    @Override
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(String industryName) {
        List<MonthlyKeywordDTO> monthlyKeywordDTO = keywordRepository.findByMonthlyKeyword(industryName);

        //monthlyKeywordDTO monthlyKeyword;
        //if (monthlyKeywordDTO == null || !monthlyKeyword.getKeyword())

        System.out.println("" + industryName);

        return monthlyKeywordDTO;

    }
//    public MonthlyKeywordDTO selectMonthlyKeyword(String industryName) {
//        MonthlyKeywordDTO monthlyKeywordDTO = new MonthlyKeywordDTO();
//
//        monthlyKeywordDTO = keywordRepository.findByMonthlyKeyword(industryName);
//        return monthlyKeywordDTO;
//    }

    // 과거 월별 조회
    @Override
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(String industryName) {
        List<KeywordMonthListDTO> keywordMonthListDTO = keywordRepository.findByKeywordMonthList(industryName);

        System.out.println("" + industryName);

        List<KeywordMonthListDTO> result = keywordMonthListDTO.stream().map(r-> new KeywordMonthListDTO(r)).collect(Collectors.toList());

        return result;
    }

    // 상승 키워드
    @Override
    public List<IncreaseKeywordDTO> selectIncreaseKeyword(String industryName) {
        List<IncreaseKeywordDTO> increaseKeywordDTO = keywordRepository.findByIncreaseKeyword(industryName);

        System.out.println("" + industryName);

        //IncreaseKeywordDTO.getIncreaseValue(industryName);

        return increaseKeywordDTO;
    }
}
