package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.MonthRankKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthRankKeywordRepository extends JpaRepository<MonthRankKeyword, String> {
    List<MonthRankKeyword> findByIndustryNameAndRegMonth(String industryName, String regMonth);
}
