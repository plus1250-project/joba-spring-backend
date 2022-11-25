package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;


    // 회원가입
    @Transactional
    @Override
    public void insertUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
        if (user != null) throw new RuntimeException("이미 등록된 이메일입니다.");

        User saveUser = User.builder()
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .nickName(userDTO.getNickName())
                .build();

        userRepository.save(saveUser);
    }

    @Override
    public String validateEmail(UserDTO userDTO) {

        User user = userRepository.findByEmail(userDTO.getEmail()).orElse(null);

        // 중복이면 true
        if(userDTO.getEmail().equals(user.getEmail())) {
            return "true";
        } else {
            return "false";
        }

    }

    // 회원 정보 조회
    @Transactional(readOnly = true)
    @Override
    public UserDTO getInfo(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail()).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        return UserDTO.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .nickName(user.getNickName())
                .build();
    }

    // 이메일 가입 여부 확인, 가입된 정보 있으면 이름 리턴
    @Override
    public boolean emailCheckNickname(String email, String nickName) {
        User user = userRepository.findByUserId(email);
        if (user != null && user.getNickName().equals(nickName)) {
            return true;
        } else {
            return false;
        }
    }

    // 닉네임 변경
    @Override
    public void updateUserNickname(UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getNickName());

        User userSave = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        User saveUser =  User.builder()
                .userId(userSave.getUserId())
                .email(userDTO.getEmail())
                .password(userSave.getPassword())
                .nickName(userDTO.getNickName())
                .build();

        userRepository.save(saveUser);
    }

    // 비밀번호 변경
    @Override
    public void updateUserPassword(UserDTO userDTO) throws Exception {

        User userSave = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String pw = encoder.encode(userDTO.getPassword());

        User saveUser =  User.builder()
                .userId(userSave.getUserId())
                .email(userDTO.getEmail())
                .password(pw)
                .nickName(userSave.getNickName())
                .build();

        userRepository.save(saveUser);
    }

    // 회원 탈퇴
    @Override
    public void deleteUser(String password, String email) throws Exception {
        System.out.println("delete serviceImpl");
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("가입되지 않은 이메일 입니다"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("비밀번호가 맞지 않습니다.");
        }
        userRepository.delete(user);
    }
}
