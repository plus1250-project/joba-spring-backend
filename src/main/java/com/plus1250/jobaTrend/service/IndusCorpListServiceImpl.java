package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;
import com.plus1250.jobaTrend.model.entity.IndusCorpList;
import com.plus1250.jobaTrend.repository.IndusCorpListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndusCorpListServiceImpl implements IndusCorpListService {
    
    @Autowired
    private IndusCorpListRepository indusCorpListRepository;
    
    @Override
    public List<IndusCorpListDTO> selectIndustry(String industryName) {
        System.out.println("" + industryName);

        // DB
        List<IndusCorpList> indusCorpList = indusCorpListRepository.findByIndusCorpInfo(industryName);

        List<IndusCorpListDTO> result = indusCorpList.stream().map(r -> new IndusCorpListDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }
}
