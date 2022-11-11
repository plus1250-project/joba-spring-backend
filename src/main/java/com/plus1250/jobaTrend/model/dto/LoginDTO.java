package com.plus1250.jobaTrend.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    private String email;
    private String password;
}