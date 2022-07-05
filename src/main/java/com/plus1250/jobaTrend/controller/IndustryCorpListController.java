package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;
import com.plus1250.jobaTrend.service.IndusCorpListService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class IndustryCorpListController {

    @Autowired
    private final IndusCorpListService indusCorpListService;

    // 산업군 기업 리스트
    @GetMapping("/indus_corp_list")
    public List<IndusCorpListDTO> selectIndusCorpList(@RequestParam IndusCorpListDTO indusCorpListDTO) {
        System.out.println("controller: IndusCorpList");
        return indusCorpListService.selectIndustry(indusCorpListDTO);
    }
}
