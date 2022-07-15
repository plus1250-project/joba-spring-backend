package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.GrowthCorp;
import lombok.Builder;
import lombok.Getter;

@Getter
public class GrowthCorpDTO {
    private String industryName;
    private String regMonth;
    private String corpName;
    private float growthRate;
    private int corpRank;

    public GrowthCorpDTO() {}

    public GrowthCorpDTO(String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }

    public GrowthCorpDTO(GrowthCorp r) {
        this.industryName = r.getIndustryName();
        this.regMonth = r.getRegMonth();
        this.corpName = r.getCorpName();
        this.growthRate = r.getGrowthRate();
        this.corpRank = r.getCorpRank();
    }

    @Builder
    public GrowthCorpDTO(String industryName, String regMonth, String corpName, float growthRate, int corpRank) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.corpName = corpName;
        this.growthRate = growthRate;
        this.corpRank = corpRank;
    }
}
