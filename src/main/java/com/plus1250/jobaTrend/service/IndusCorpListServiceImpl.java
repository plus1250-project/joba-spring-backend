package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;
import com.plus1250.jobaTrend.model.entity.IndusCorpList;
import com.plus1250.jobaTrend.repository.IndusCorpListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class IndusCorpListServiceImpl implements IndusCorpListService {
    
    @Autowired
    private final IndusCorpListRepository indusCorpListRepository;
    
    @Override
    public List<IndusCorpListDTO> selectIndustry(IndusCorpListDTO indusCorpListDTO) {
        System.out.println("serviceImpl :" + indusCorpListDTO);

        List<IndusCorpList> indusCorpList = indusCorpListRepository.findByIndusCorpInfo(indusCorpListDTO.getIndustryName());

        List<IndusCorpListDTO> result = indusCorpList.stream().map(r -> new IndusCorpListDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }
}
