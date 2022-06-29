package com.plus1250.jobaTrend.repository;



import com.plus1250.jobaTrend.model.dto.IncreaseKeywordDTO;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncreaseKeywordRepository extends JpaRepository<IncreaseKeyword, String> {

    List<IncreaseKeyword> findByIncreaseKeyword(String industryName);
}

