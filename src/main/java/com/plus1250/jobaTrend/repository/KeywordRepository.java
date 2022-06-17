package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;
import com.plus1250.jobaTrend.model.dto.KeywordMonthListDTO;
import com.plus1250.jobaTrend.model.dto.MainKeywordDTO;
import com.plus1250.jobaTrend.model.dto.MonthlyKeywordDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository {

    MainKeywordDTO findByMainKeyword(String industryName);
    MonthlyKeywordDTO findByMonthlykeyword(String industryName);
    KeywordMonthListDTO findByKeywordMonthList(String industryName);
    IncreaseKeywordDTO findByIncreaseKeyword(String industryName);

}
