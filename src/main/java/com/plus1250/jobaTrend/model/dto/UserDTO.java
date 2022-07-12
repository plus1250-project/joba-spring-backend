package com.plus1250.jobaTrend.model.dto;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int idx;
    private String password;
    private String email;
    private String nickName;
    public UsernamePasswordAuthenticationToken toAuthentication() {
        return null;
    }

    //public String getRefreshToken() {
    //}
}