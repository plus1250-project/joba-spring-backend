package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository {

    List<MainKeywordDTO> findByMainKeyword(String industryName);
    List<MonthlyKeywordDTO> findByMonthlyKeyword(String industryName);
    List<KeywordMonthListDTO> findByKeywordMonthList(String industryName);
    List<IncreaseKeywordDTO> findByIncreaseKeyword(String industryName);
}
