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
@RequestMapping("/industry")
public class CorpController {

    private final CorpService corpService;

    // 산업군 우량 기업 리스트
    @GetMapping("/corporation/{industryName}/{regMonth}")
    public List<IndusCorpDTO> selectIndusCorp(@PathVariable String industryName, @PathVariable String regMonth) {
        return corpService.selectIndusCorp(new IndusCorpDTO(industryName, regMonth));
    }

    // 산업군 성장 기업 리스트
    @GetMapping("/corporation-growth/{industryName}/{regMonth}")
    public List<GrowthCorpDTO> selectGrowthCorp(@PathVariable String industryName, @PathVariable String regMonth) {
        return corpService.selectGrowthCorp(new GrowthCorpDTO(industryName, regMonth));
    }

}
