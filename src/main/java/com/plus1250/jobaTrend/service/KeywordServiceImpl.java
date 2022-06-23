package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import com.plus1250.jobaTrend.model.entity.MainKeyword;
import com.plus1250.jobaTrend.model.entity.MonthlyKeyword;
import com.plus1250.jobaTrend.repository.IncreaseKeywordRepository;
import com.plus1250.jobaTrend.repository.KeywordMonthListRepository;
import com.plus1250.jobaTrend.repository.MainKeywordRepository;
import com.plus1250.jobaTrend.repository.MonthlyKeywordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private MainKeywordRepository mainKeywordRepository;

    @Autowired
    private KeywordMonthListRepository keywordMonthListRepository;

    @Autowired
    private MonthlyKeywordRepository monthlyKeywordRepository;

    @Autowired
    private IncreaseKeywordRepository increaseKeywordRepository;

    // 언급량 분석
    @Override
    public List<MainKeywordDTO> selectMainKeyword(String industryName) {

        // 받은 파라미터 값 확인
        System.out.println("" + industryName);

        // DB
        List<MainKeyword> mainKeyword = mainKeywordRepository.findByMainKeyword(industryName);

        List<MainKeywordDTO> result = mainKeyword.stream().map(r -> new MainKeywordDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

    // 월별 트렌드 분석
    @Override
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(String industryName) {
        System.out.println("" + industryName);

        List<MonthlyKeyword> monthlyKeyword = monthlyKeywordRepository.findByMonthlyKeyword(industryName);

        List<MonthlyKeywordDTO> result = monthlyKeyword.stream().map(r -> new MonthlyKeywordDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

    // 과거 월별 조회
    @Override
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(String industryName) {
        System.out.println("" + industryName);

        List<KeywordMonthList> keywordMonthList = keywordMonthListRepository.findByKeywordMonthList(industryName);

        List<KeywordMonthListDTO> result = keywordMonthList.stream().map(r-> new KeywordMonthListDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

    // 상승 키워드
    @Override
    public List<IncreaseKeywordDTO> selectIncreaseKeyword(String industryName) {
        System.out.println("" + industryName);

        List<IncreaseKeyword> increaseKeyword = increaseKeywordRepository.findByIncreaseKeyword(industryName);

        List<IncreaseKeywordDTO> result = increaseKeyword.stream().map(r -> new IncreaseKeywordDTO(r)).collect(Collectors.toList());
        // System.out.println(result);

        return result;
    }
}