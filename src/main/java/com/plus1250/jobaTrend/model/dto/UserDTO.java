package com.plus1250.jobaTrend.model.dto;

import com.plus1250.jobaTrend.model.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {

    private String email;
    private String pw;

    public UserDTO(String email, String pw) {
        this.email = email;
        this.pw = pw;
    }
    public UserDTO() {}

}
