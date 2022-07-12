package com.plus1250.jobaTrend.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokenDTO {

    // private String grantType;
    private String accessToken;
    private String refreshToekn;
    private String tokenType = "Bearer";
    private Long accessTokenExpireDate;

    public String getRefreshToken() {
        return refreshToekn;
    }
}
