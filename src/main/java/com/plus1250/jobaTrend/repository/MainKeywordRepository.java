package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;

import com.plus1250.jobaTrend.model.entity.MainKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MainKeywordRepository extends JpaRepository<MainKeyword, String> {

    List<MainKeyword> findByMainKeyword(String industryName);
}