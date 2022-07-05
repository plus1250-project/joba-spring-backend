package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.IndusCorpListDTO;

import java.util.List;

public interface IndusCorpListService {
    List<IndusCorpListDTO> selectIndusCorpList(IndusCorpListDTO indusCorpListDTO);
}
