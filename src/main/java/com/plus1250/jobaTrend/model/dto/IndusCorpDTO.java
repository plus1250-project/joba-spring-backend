package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.IndusCorp;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IndusCorpDTO {
    private String industryName;
    private String regMonth;
    private String corpName;
    private int corpRank;

    public IndusCorpDTO() {}

    public IndusCorpDTO(String industryName) {
        this.industryName = industryName;
    }

    public IndusCorpDTO(IndusCorp r) {
        this.industryName = r.getIndustryName();
        this.regMonth = r.getRegMonth();
        this.corpName = r.getCorpName();
        this.corpRank = r.getCorpRank();
    }

    @Builder
    public IndusCorpDTO(String industryName, String regMonth, String corpName, int corpRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.corpName = corpName;
        this.corpRank = corpRank;
    }
}
