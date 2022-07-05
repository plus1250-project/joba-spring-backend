package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.IndusCorp;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndusCorpRepository extends JpaRepository<IndusCorp, String> {
    List<IndusCorp> findByIndustryNameAndRegMonth(String industryName, String regMonth);

}
