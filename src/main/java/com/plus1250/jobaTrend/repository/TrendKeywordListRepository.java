package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.TrendKeywordList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TrendKeywordListRepository extends JpaRepository<TrendKeywordList, String> {

    List<TrendKeywordList> findByIndustryNameAndRegMonth(String industryName, Date issueDate);
}
