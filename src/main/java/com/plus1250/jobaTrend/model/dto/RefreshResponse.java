package com.plus1250.jobaTrend.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RefreshResponse {

    private String accessToken;
    private String refreshToekn;

    private String tokenType = "Bearer";

    @Builder
    public RefreshResponse(String accessToken, String refreshToekn) {
        this.accessToken = accessToken;
        this.refreshToekn = refreshToekn;
    }
}
