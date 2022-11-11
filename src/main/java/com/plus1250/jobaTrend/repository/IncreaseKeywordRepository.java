package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncreaseKeywordRepository extends JpaRepository<IncreaseKeyword, String> {
    IncreaseKeyword findByIndustryNameAndRegMonth(String industryName, String regMonth);
}

