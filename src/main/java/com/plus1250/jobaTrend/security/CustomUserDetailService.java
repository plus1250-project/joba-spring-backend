package com.plus1250.jobaTrend.security;

import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.repository.UserRepository;
import com.plus1250.jobaTrend.security.handler.AuthenticationFailureHandlerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
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

    private final AuthenticationFailureHandlerImpl authenticationFailureHandler;

    @Override
    public UserDetails loadUserByUsername(String email){
        if(email.isEmpty()) {
            System.out.println("이메일 없음");
        } else {
            System.out.println(email);
        }

        User user = userRepository.findByEmail(email).orElseThrow(() -> new BadCredentialsException("잘못된 이메일"));
//        User user = userRepository.findByEmail(email).orElseThrow(() ->  new AuthenticationServiceException("이메일 확인"));
        System.out.println("사용자 확인 : " + user.getEmail() + " | " + user.getNickName());
        return new UserDetailsImpl(
                user.getPassword(),
                user.getEmail(),
                user.getNickName(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

}
