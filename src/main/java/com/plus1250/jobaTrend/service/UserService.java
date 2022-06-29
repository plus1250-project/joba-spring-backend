package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.UserDTO;

public interface UserService {

    // 회원가입
    void insertUser(UserDTO userDTO);

    // 회원 정보 수정
    void updateUser(UserDTO userDTO);

    // 회원탈퇴
    void deleteUser(UserDTO userDTO);

    // 로그인
    Boolean loginUser(UserDTO userDTO);
}
