package com.plus1250.jobaTrend.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshRequest {

    private String accessToken;

    private String refreshToken;

    private String tokenType = "Bearer";

    public String getRefreshToken() {
        return refreshToken;
    }

    @Builder
    public RefreshRequest(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}