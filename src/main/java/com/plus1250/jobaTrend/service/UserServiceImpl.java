package com.plus1250.jobaTrend.service;

import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.dto.RefreshRequest;
import com.plus1250.jobaTrend.model.dto.TokenDTO;
import com.plus1250.jobaTrend.model.entity.RefreshToken;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.RefreshTokenRepository;
import com.plus1250.jobaTrend.repository.UserRepository;
import com.plus1250.jobaTrend.model.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final RefreshTokenRepository refreshTokenRepository;
    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    // 회원가입
    @Transactional
    public void insertUser(UserDTO userDTO) {
        User user = userRepository.findById(userDTO.getEmail()).orElse(null);
        if (user != null) throw new RuntimeException("이미 등록된 이메일입니다.");

        User saveUser = User.builder()
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .email(userDTO.getEmail())
                .nickName(user.getNickName())
                .build();

        userRepository.save(saveUser);
    }

    // 회원 정보 조회
    @Transactional(readOnly = true)
    public UserDTO getInfo(String email) {
        User user = userRepository.findByInfo(email).orElseThrow(() -> new RuntimeException("회원 정보가 존재하지 않습니다."));
        return UserDTO.builder()
                .idx(user.getIdx())
                .email(user.getEmail())
                .nickName(user.getNickName())
                .build();
    }

    // 로그인
    @Transactional
    public TokenDTO loginUser(@RequestBody UserDTO userDTO) {

        // AuthenticationToken 생성
        UsernamePasswordAuthenticationToken authenticationToken = userDTO.toAuthentication();

        User saveUser = userRepository.findByEmail(userDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("가입되지 않은 이메일 입니다."));
        if (!passwordEncoder.matches(userDTO.getPassword(), saveUser.getPassword())) {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }

        TokenDTO tokenDTO = jwtTokenProvider.crateToken(authenticationToken);

        RefreshToken refreshToken = RefreshToken.builder()
                .key(authenticationToken.getName())
                .value(tokenDTO.getRefreshToken())
                .build();

        refreshTokenRepository.save(refreshToken);

        return tokenDTO;
    }

    @Transactional
    public TokenDTO reissue(RefreshRequest refreshRequest) {
        // Refresh Token 검증
        if (!jwtTokenProvider.validateToken(refreshRequest.getRefreshToken())) {
            throw new RuntimeException("Refresh Token 이 유효하지 않습니다.");
        }

        // Access Token 에서 Member ID 추출
        Authentication authentication = jwtTokenProvider.getAuthentication(refreshRequest.getAccessToken());

        // Refresh Token 값 가져옴
        RefreshToken refreshToken = refreshTokenRepository.findByKey(authentication.getName())
                .orElseThrow(() -> new RuntimeException("로그아웃 된 사용자입니다."));

        // Refresh Token 검사
        if (!refreshToken.getValue().equals(refreshRequest.getRefreshToken())) {
            throw new RuntimeException("토큰의 유저 정보가 일치하지 않습니다.");
        }

        // 새로운 토큰 생성
        TokenDTO tokenDTO = jwtTokenProvider.crateToken(authentication);

        // 정보 업데이트
        RefreshToken newRefreshToken = refreshToken.updateValue(tokenDTO.getRefreshToken());
        refreshTokenRepository.save(newRefreshToken);

        // 토큰 발급
        return tokenDTO;
    }

    // 이메일 가입 여부 확인, 가입된 정보 있으면 이름 리턴
    @Override
    public boolean emailCheckUser(String email, String nickName) {
        User user = userRepository.findUserByUserId(email);
        if (user != null && user.getNickName().equals(nickName)) {
            return true;
        } else {
            return false;
        }
    }

    // 회원 정보 수정
    @Transactional
    public String updateUser(User user) throws Exception {
        User userEntity = userRepository.findById(user.getEmail())
                .orElseThrow(() -> new RuntimeException("로그인 유저 정보가 없습니다."));
        userEntity.update(passwordEncoder.encode(user.getPassword()), user.getNickName());
        return userEntity.getEmail();
    }


    // 회원 탈퇴
    @Override
    public void deleteUser(String password, String email) throws Exception {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("가입되지 않은 이메일 입니다"));

        if (!passwordEncoder.matches(password, String.valueOf(passwordEncoder))) {
            throw new Exception("비밀번호가 맞지 않습니다.");
        }
        userRepository.delete(user);
    }

}