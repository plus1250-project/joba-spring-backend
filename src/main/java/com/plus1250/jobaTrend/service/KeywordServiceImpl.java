package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import com.plus1250.jobaTrend.model.entity.TrendKeywordList;
import com.plus1250.jobaTrend.model.entity.MonthKeywordList;

import com.plus1250.jobaTrend.repository.IncreaseKeywordRepository;
import com.plus1250.jobaTrend.repository.KeywordMonthListRepository;
import com.plus1250.jobaTrend.repository.TrendKeywordListRepository;
import com.plus1250.jobaTrend.repository.MonthKeywordListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private final MonthKeywordListRepository monthKeywordListRepository;

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

    // 월별 키워드 리스트
    @Override
    public List<MonthKeywordListDTO> selectMonthKeywordList(MonthKeywordListDTO monthKeywordListDTO) {
        List<MonthKeywordList> monthKeywordList = monthKeywordListRepository.findByKeywordAndIndustryNameAndRegMonth(monthKeywordListDTO.getKeyword(), monthKeywordListDTO.getIndustryName(), monthKeywordListDTO.getRegMonth());
        List<MonthKeywordListDTO> result = monthKeywordList.stream().map(r -> new MonthKeywordListDTO(r)).collect(Collectors.toList());

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