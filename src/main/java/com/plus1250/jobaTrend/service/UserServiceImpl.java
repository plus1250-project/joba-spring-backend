package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // 회원가입
    @Override
    public void insertUser(String email, String pw) {
        User user = new User();

        user.setEmail(email);
        user.setPw(pw);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPw(passwordEncoder.encode(pw));
        this.userRepository.save(user);
        return user.getEmail(email);
    }


    // 회원 정보 수정

    // 회원탈퇴

    // 로그인

}
