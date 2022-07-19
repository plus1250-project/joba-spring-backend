package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.GrowthCorpDTO;
import com.plus1250.jobaTrend.model.dto.IndusCorpDTO;
import com.plus1250.jobaTrend.model.entity.GrowthCorp;
import com.plus1250.jobaTrend.model.entity.IndusCorp;
import com.plus1250.jobaTrend.repository.GrowthCorpRepository;
import com.plus1250.jobaTrend.repository.IndusCorpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CorpServiceImpl implements CorpService {

    @Autowired
    private final IndusCorpRepository indusCorpRepository;

    @Autowired
    private final GrowthCorpRepository growthCorpRepository;
    
    @Override
    public List<IndusCorpDTO> selectIndusCorp(IndusCorpDTO indusCorpDTO) {
        System.out.println("serviceImpl :" + indusCorpDTO);
        List<IndusCorp> indusCorps = indusCorpRepository.findByIndustryNameAndRegMonth(indusCorpDTO.getIndustryName(), indusCorpDTO.getRegMonth());
        List<IndusCorpDTO> result = indusCorps.stream().map(r -> new IndusCorpDTO(r)).collect(Collectors.toList());
        System.out.println(result);

        return result;
    }

    @Override
    public List<GrowthCorpDTO> selectGrowthCorp(GrowthCorpDTO growthCorpDTO) {
        System.out.println("growthCorp service : " + growthCorpDTO);
        List<GrowthCorp> growthCorps = growthCorpRepository.findByIndustryNameAndRegMonth(growthCorpDTO.getIndustryName(), growthCorpDTO.getRegMonth());
        List<GrowthCorpDTO> result = growthCorps.stream().map(r -> new GrowthCorpDTO(r)).collect(Collectors.toList());

        return result;
    }

}
