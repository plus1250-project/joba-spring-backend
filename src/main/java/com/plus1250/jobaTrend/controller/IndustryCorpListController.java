package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;
import com.plus1250.jobaTrend.service.IndusCorpListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class IndustryCorpListController {

    private final IndusCorpListService indusCorpListService;

    // 산업군
    @PostMapping("/indus_corp_list")
    public List<IndusCorpListDTO> selectIndustry(@RequestParam IndusCorpListDTO industryName) {
        System.out.println("selectIndustry called!");
        return indusCorpListService.selectIndustry(industryName);
    }
}
