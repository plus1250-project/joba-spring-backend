package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.GrowthCorpDTO;
import com.plus1250.jobaTrend.model.dto.IndusCorpDTO;
import com.plus1250.jobaTrend.service.CorpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/corp")
public class CorpController {

    @Autowired
    private final CorpService corpService;

    // 산업군 기업 리스트
    @GetMapping("/indus-corp/{industryName}/{regMonth}")
    public List<IndusCorpDTO> selectIndusCorp(@PathVariable String industryName, @PathVariable String regMonth) {

        System.out.println("indus-corp : " + industryName + " | " + regMonth);

        return corpService.selectIndusCorp(new IndusCorpDTO(industryName, regMonth));
    }
    @GetMapping("/growth-corp/{industryName}/{regMonth}")
    public List<GrowthCorpDTO> selectGrowthCorp(@PathVariable String industryName, @PathVariable String regMonth) {
        System.out.println("Growth-corp : " + industryName + " | " + regMonth);

        return corpService.selectGrowthCorp(new GrowthCorpDTO(industryName, regMonth));
    }
}
