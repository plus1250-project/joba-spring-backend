package com.plus1250.jobaTrend.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    private String userId;

    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "이메일 형식으로 입력해 주세요.")
    private String userEmail;

    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Length(min=8, max=15, message="비밀번호는 8자 이상, 15자 이하로 입력해 주세요.")
    private String userPw;

}
