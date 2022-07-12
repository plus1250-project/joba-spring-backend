package com.plus1250.jobaTrend.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshRequest {

    private String accessToken;

    private String refreshToekn;

    private String tokenType = "Bearer";

    public String getRefreshToken() {
        return refreshToekn;
    }

    @Builder
    public RefreshRequest(String accessToken, String refreshToekn) {
        this.accessToken = accessToken;
        this.refreshToekn = refreshToekn;
    }
}