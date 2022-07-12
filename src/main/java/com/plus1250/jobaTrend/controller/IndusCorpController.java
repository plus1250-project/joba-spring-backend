package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IndusCorpDTO;
import com.plus1250.jobaTrend.service.IndusCorpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class IndusCorpController {

    @Autowired
    private final IndusCorpService indusCorpService;

    // 산업군 기업 리스트
    @GetMapping("/indus-corp/{industryName}/{regMonth}")
    public List<IndusCorpDTO> selectIndusCorp(@PathVariable String industryName, @PathVariable String regMonth) {

        System.out.println("indus-corp : " + industryName + " | " + regMonth);

        return indusCorpService.selectIndusCorp(new IndusCorpDTO(industryName, regMonth));
    }
}
