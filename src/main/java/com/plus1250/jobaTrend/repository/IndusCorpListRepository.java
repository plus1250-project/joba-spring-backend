package com.plus1250.jobaTrend.repository;

import com.plus1250.jobaTrend.model.entity.IndusCorpList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IndusCorpListRepository extends JpaRepository<IndusCorpList, String> {
    List<IndusCorpList> findByIndusCorpInfo(String industryName);

}
