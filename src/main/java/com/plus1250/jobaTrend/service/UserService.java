package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.RefreshRequest;
import com.plus1250.jobaTrend.model.dto.TokenDTO;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    TokenDTO loginUser(@RequestBody UserDTO userDTO);

    boolean emailCheckUser(String email, String nickName);

    //String updateUserPassword(String password) throws Exception;

    //UserDTO updateUserNickname(String nickName) throws Exception;


    UserDTO getInfo(String email);

    void insertUser(UserDTO userDTO);

    TokenDTO reissue(RefreshRequest refreshRequest);

    // 닉네임 수정
    void updateUserNickname(UserDTO userDTO) throws Exception;

    // 비밀번호 수정
    void updateUserPassword(UserDTO userDTO) throws Exception;

    // 회원 탈퇴
    void deleteUser(String password, String email) throws Exception;
}
