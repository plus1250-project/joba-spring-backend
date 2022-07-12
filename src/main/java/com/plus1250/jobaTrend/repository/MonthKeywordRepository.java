package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.MonthKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthKeywordRepository extends JpaRepository<MonthKeyword, String> {

    List<MonthKeyword> findByKeywordAndIndustryNameAndRegMonthGreaterThanEqualAndRegMonthLessThanEqual(String keyword, String industryName, String fromMonth , String regMonth);
}

