package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.GrowthCorp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GrowthCorpRepository extends JpaRepository<GrowthCorp, String> {
    List<GrowthCorp> findByIndustryNameAndRegMonth(String industryName, String regMonth);
}
