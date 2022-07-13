package com.plus1250.jobaTrend.security;

import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        if(email.isEmpty()) {
            System.out.println("이메일 없음");
        } else {
            System.out.println(email);
        }

        User user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("사용자를 찾을 수 없습니다"));
        System.out.println("사용자 확인 : " + user.getEmail() + " | " + user.getNickName());
        return new UserDetailsImpl(
                user.getPassword(),
                user.getEmail(),
                user.getNickName(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

}
