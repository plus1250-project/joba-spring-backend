package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.*;

import com.plus1250.jobaTrend.model.entity.*;

import com.plus1250.jobaTrend.repository.*;
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
    private final TrendKeywordRepository trendKeywordRepository;

    @Autowired
    private final MonthKeywordRepository monthKeywordRepository;

    @Autowired
    private final MonthRankKeywordRepository monthRankKeywordRepository;

    @Autowired
    private final CompareKeywordRepository compareKeywordRepository;

    // 상승 키워드
    @Override
    public String selectIncreaseKeyword(IncreaseKeywordDTO increaseKeywordDTO) {
        IncreaseKeyword increaseKeyword = increaseKeywordRepository.findByIndustryNameAndRegMonth(increaseKeywordDTO.getIndustryName(), increaseKeywordDTO.getRegMonth());
        String result = increaseKeyword.getKeyword();

        return result;
    }

    // 트렌드 키워드 리스트
    @Override
    public List<TrendKeywordDTO> selectTrendKeyword(TrendKeywordDTO trendKeywordDTO) {
        List<TrendKeyword> trendKeywords = trendKeywordRepository.findByIndustryNameAndIssueDate(trendKeywordDTO.getIndustryName(), trendKeywordDTO.getIssueDate());
        List<TrendKeywordDTO> result = trendKeywords.stream().map(r-> new TrendKeywordDTO(r)).collect(Collectors.toList());

        return result;
    }

    // 월별 키워드 리스트
    @Override
    public List<MonthKeywordDTO> selectMonthKeyword(MonthKeywordDTO monthKeywordDTO) {
        String fromMonth = "2021-10";
        List<MonthKeyword> monthKeywords = monthKeywordRepository.findByKeywordAndIndustryNameAndRegMonthGreaterThanEqualAndRegMonthLessThanEqual(monthKeywordDTO.getKeyword(), monthKeywordDTO.getIndustryName(), fromMonth, monthKeywordDTO.getRegMonth());
        List<MonthKeywordDTO> result = monthKeywords.stream().map(r -> new MonthKeywordDTO(r)).collect(Collectors.toList());

        return result;
    }

    // 월별 랭킹 키워드 리스트
    @Override
    public List<MonthRankKeywordDTO> selectMonthRankKeyword(MonthRankKeywordDTO monthRankKeywordDTO) {
        List<MonthRankKeyword> monthRankKeywords = monthRankKeywordRepository.findByIndustryNameAndRegMonth(monthRankKeywordDTO.getIndustryName(), monthRankKeywordDTO.getRegMonth());
        List<MonthRankKeywordDTO> result = monthRankKeywords.stream().map(r -> new MonthRankKeywordDTO(r)).collect(Collectors.toList());

        return result;
    }

    // 월별 랭킹 키워드 전월 대비 분석 리스트
    @Override
    public List<CompareKeywordDTO> selectCompareKeyword(CompareKeywordDTO compareKeywordDTO) {
        System.out.println("serviceImpl :" + compareKeywordDTO);

        List<CompareKeyword> compareKeywords = compareKeywordRepository.findByIndustryNameAndRegMonth(compareKeywordDTO.getIndustryName(), compareKeywordDTO.getRegMonth());

        List<CompareKeywordDTO> result = compareKeywords.stream().map(r-> new CompareKeywordDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }


}