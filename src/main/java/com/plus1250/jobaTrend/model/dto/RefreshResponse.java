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
    private String refreshToken;

    private String tokenType = "Bearer";

    @Builder
    public RefreshResponse(String accessToken, String refreshToken) {
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }
}
