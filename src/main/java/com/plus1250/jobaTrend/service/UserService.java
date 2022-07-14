package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.RefreshRequest;
import com.plus1250.jobaTrend.model.dto.TokenDTO;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import org.springframework.web.bind.annotation.RequestBody;

public interface UserService {

    TokenDTO loginUser(@RequestBody UserDTO userDTO);

    boolean emailCheckUser(String email, String nickName);

    // 회원 정보 수정
    String updateUser(User user) throws Exception;

//    void updateUserNickname(User user);

    UserDTO getInfo(String email);

    void insertUser(UserDTO userDTO);

    TokenDTO reissue(RefreshRequest refreshRequest);

    // 회원 탈퇴
    void deleteUser(String password, String email) throws Exception;
}
