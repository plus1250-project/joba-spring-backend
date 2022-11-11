package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.IncreaseKeyword;
import lombok.Builder;
import lombok.Getter;

@Getter
public class IncreaseKeywordDTO {
    private String industryName;
    private String regMonth;
    private String keyword;

    public IncreaseKeywordDTO() {}

    public IncreaseKeywordDTO(String industryName, String regMonth) {
        this.industryName = industryName;
        this.regMonth = regMonth;
    }

    public IncreaseKeywordDTO(IncreaseKeyword r) {
        this.industryName = r.getIndustryName();
        this.regMonth = r.getRegMonth();
        this.keyword = r.getKeyword();
    }

    @Builder
    public IncreaseKeywordDTO(String industryName, String regMonth, String keyword) {
        this.industryName = industryName;
        this.regMonth = regMonth;
        this.keyword = keyword;
    }
}






