package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import com.plus1250.jobaTrend.model.entity.MonthlyKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MonthlyKeywordRepository extends JpaRepository<MonthlyKeyword, String> {
    List<MonthlyKeywordDTO> findByMonthlyKeyword(String industryName);
}
