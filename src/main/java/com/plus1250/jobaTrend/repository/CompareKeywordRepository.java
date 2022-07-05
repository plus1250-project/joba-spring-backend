package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.CompareKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompareKeywordRepository extends JpaRepository<CompareKeyword, String> {
    List<CompareKeyword> findByIndustryNameAndRegMonth(String industryName, String regMonth);
}
