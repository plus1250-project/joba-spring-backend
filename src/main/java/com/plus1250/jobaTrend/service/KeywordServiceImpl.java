package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import com.plus1250.jobaTrend.model.entity.TrendKeywordList;
import com.plus1250.jobaTrend.model.entity.MonthlyKeyword;

import com.plus1250.jobaTrend.repository.IncreaseKeywordRepository;
import com.plus1250.jobaTrend.repository.KeywordMonthListRepository;
import com.plus1250.jobaTrend.repository.TrendKeywordListRepository;
import com.plus1250.jobaTrend.repository.MonthlyKeywordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class KeywordServiceImpl implements KeywordService {

    @Autowired
    private final IncreaseKeywordRepository increaseKeywordRepository;

    @Autowired
    private final TrendKeywordListRepository trendKeywordListRepository;

    @Autowired
    private final KeywordMonthListRepository keywordMonthListRepository;

    @Autowired
    private final MonthlyKeywordRepository monthlyKeywordRepository;

    // 상승 키워드
    @Override
    public String selectIncreaseKeyword(IncreaseKeywordDTO increaseKeywordDTO) {
        IncreaseKeyword increaseKeyword = increaseKeywordRepository.findByIndustryNameAndRegMonth(increaseKeywordDTO.getIndustryName(), increaseKeywordDTO.getRegMonth());
        String result = increaseKeyword.getKeyword();

        return result;
    }

    // 트렌드 키워드 리스트
    @Override
    public List<TrendKeywordListDTO> selectTrendKeywordList(TrendKeywordListDTO trendKeywordListDTO) {
        List<TrendKeywordList> trendKeywordList = trendKeywordListRepository.findByIndustryNameAndRegMonth(trendKeywordListDTO.getIndustryName(), trendKeywordListDTO.getIssueDate());
        List<TrendKeywordListDTO> result = trendKeywordList.stream().map(r-> new TrendKeywordListDTO(r)).collect(Collectors.toList());

        return result;
    }

    // 월별 트렌드 분석
    @Override
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(MonthlyKeywordDTO monthlyKeywordDTO) {
        System.out.println("serviceImpl :" + monthlyKeywordDTO);

        List<MonthlyKeyword> monthlyKeyword = monthlyKeywordRepository.findByMonthlyKeyword(monthlyKeywordDTO.getIndustryName());

        List<MonthlyKeywordDTO> result = monthlyKeyword.stream().map(r -> new MonthlyKeywordDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

    // 과거 월별 조회
    @Override
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(KeywordMonthListDTO keywordMonthListDTO) {
        System.out.println("serviceImpl :" + keywordMonthListDTO);

        List<KeywordMonthList> keywordMonthList = keywordMonthListRepository.findByKeywordMonthList(keywordMonthListDTO.getIndustryName());

        List<KeywordMonthListDTO> result = keywordMonthList.stream().map(r-> new KeywordMonthListDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }


}