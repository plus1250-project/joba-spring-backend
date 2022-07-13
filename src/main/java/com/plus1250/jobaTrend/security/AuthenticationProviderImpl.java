package com.plus1250.jobaTrend.security;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    private final UserDetailsService userDetailsService;

    @Autowired
    private final PasswordEncoder passwordEncoder;


    // 인증 구현
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 전달 받은 UsernamePasswordAuthenticationToken
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;

        // AuthenticaionFilter에서 생성된 토큰으로부터 이메일, 비밀번호 추출
        String username = token.getName();
        String password = (String) token.getCredentials();

        System.out.println("인증 프로바이더 : " + username + " - " + password);

        // 해당 회원 Database 조회
        UserDetailsImpl userDetail = (UserDetailsImpl) userDetailsService.loadUserByUsername(username);

        System.out.println("유저 정보 확인 완료 : " + userDetail.getUsername()); //이메일

        // 비밀번호 확인
        if (!passwordEncoder.matches(password, userDetail.getPassword()))
            throw new BadCredentialsException(userDetail.getUsername() + "Invalid password");

        // 인증 성공 시 UsernamePasswordAuthenticationToken 반환
        return new UsernamePasswordAuthenticationToken(userDetail.getUsername(), "", userDetail.getAuthorities());
    }

    // 동작 여부 설정
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}