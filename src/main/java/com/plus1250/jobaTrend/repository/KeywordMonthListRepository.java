package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.entity.KeywordMonthList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordMonthListRepository extends JpaRepository<KeywordMonthList, String> {
    List<KeywordMonthListDTO> findByKeywordMonthList(String industryName);
}
