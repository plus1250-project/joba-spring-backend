package com.plus1250.jobaTrend.model.dto;

import lombok.*;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String password;
    private String email;
    private String nickName;

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return null;
    }


    public UserDTO(String password, String email, String nickName) {
        this.password = password;
        this.email = email;
        this.nickName = nickName;
    }

    public UserDTO(String password, String email) {
        this.password = password;
        this.email = email;
    }

}
