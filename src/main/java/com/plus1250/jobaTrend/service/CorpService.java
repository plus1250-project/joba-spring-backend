package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.GrowthCorpDTO;
import com.plus1250.jobaTrend.model.dto.IndusCorpDTO;

import java.util.List;

public interface CorpService {
    List<IndusCorpDTO> selectIndusCorp(IndusCorpDTO indusCorpDTO);

    List<GrowthCorpDTO> selectGrowthCorp(GrowthCorpDTO growthCorpDTO);
}
