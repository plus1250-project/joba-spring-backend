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
public class IndustryCorpController {

    @Autowired
    private final IndusCorpService indusCorpService;

    // 산업군 기업 리스트
    @GetMapping("/indus_corp_list")
    public List<IndusCorpDTO> selectIndusCorp(@RequestParam IndusCorpDTO indusCorpDTO) {
        System.out.println("controller: IndusCorpList");
        return indusCorpService.selectIndusCorp(indusCorpDTO);
    }
}
