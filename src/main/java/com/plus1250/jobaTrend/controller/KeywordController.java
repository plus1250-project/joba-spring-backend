package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.service.KeywordService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// 언급량 분석 / 월별트렌드 키워드 / 과거 월별 조회 / 상승 키워드
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/")
public class KeywordController {

    private final KeywordService keywordService;

    public KeywordController(KeywordService keywordService) {
        this.keywordService = keywordService;
    }

    // 언급량 분석
    @PostMapping("/main_keyword/{keyword}{daily_date}")
    public List<MainKeywordDTO> selectMainKeyword(@RequestBody String industryName) {
        System.out.println("selectMainKeyword called!");
        return KeywordService.selectMainKeyword(industryName);
    }

//    public MainKeywordDTO selectMainKeyword(@RequestBody String industryName) {
//        try {
//            MainKeywordDTO mainKeywordDTO = KeywordService.selectMainKeyword(industryName);
//            return KeywordService.selectMainKeyword(industryName);
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            return null;
//        }
//    }

    // 월별 트렌드 분석
    @PostMapping("/monthly_keyword/{keyword}")
    public List<MonthlyKeywordDTO> selectMonthlyKeyword(@RequestBody String industryName) {
        System.out.println("selectMonthlyKeyword called!");
        return KeywordService.selectMonthlyKeyword(industryName);
    }

    // 과거 월별 조회
    @PostMapping("/keyword_month_list/{keyword}{month}")
    public List<KeywordMonthListDTO> selectKeywordMonthInfo(@RequestBody String industryName) {
        System.out.println("selectKeywordMonthInfo called!");
        return KeywordService.selectKeywordMonthInfo(industryName);
    }

    // 상승 키워드
    @PostMapping("/increase_keyword/{keyword]")
    public List<IncreaseKeywordDTO> selectIncreaseKeyword(@RequestBody String industryName) {
        System.out.println("selectIncreaseKeyword called!");
        return KeywordService.selectIncreaseKeyword(industryName);
    }
}

