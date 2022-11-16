package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.MonthKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MonthKeywordRepository extends JpaRepository<MonthKeyword, String> {
    List<MonthKeyword> findByKeywordAndIndustryNameAndInputDate(String keyword, String industryName, Date inputDate);
}
