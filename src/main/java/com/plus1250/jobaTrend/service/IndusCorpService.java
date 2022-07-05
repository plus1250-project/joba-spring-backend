package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IndusCorpDTO;

import java.util.List;

public interface IndusCorpService {
    List<IndusCorpDTO> selectIndusCorp(IndusCorpDTO indusCorpDTO);
}
