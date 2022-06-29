package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;
import com.plus1250.jobaTrend.service.IndusCorpListService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class IndustryCorpListController {

    private final IndusCorpListService indusCorpListService;

    public IndustryCorpListController(IndusCorpListService indusCorpListService) {
        this.indusCorpListService = indusCorpListService;
    }

    // 산업군
    @GetMapping("/indus_corp_list")
    public List<IndusCorpListDTO> selectIndustry(@RequestParam(value ="industry_name") String industryName) {
        System.out.println("selectIndustry called!");
        return indusCorpListService.selectIndustry(industryName);
    }
}
