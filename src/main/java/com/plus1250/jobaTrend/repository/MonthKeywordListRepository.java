package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.MonthKeywordList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthKeywordListRepository extends JpaRepository<MonthKeywordList, String> {

    List<MonthKeywordList> findByKeywordAndIndustryNameAndRegMonth(String keyword, String industryName, String regMonth);
}

