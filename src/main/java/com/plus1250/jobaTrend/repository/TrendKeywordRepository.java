package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.TrendKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TrendKeywordRepository extends JpaRepository<TrendKeyword, String> {
    List<TrendKeyword> findByIndustryNameAndFromDate(String industryName, Date fromDate);
}
