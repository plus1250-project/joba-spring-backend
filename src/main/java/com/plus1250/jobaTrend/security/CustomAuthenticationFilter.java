package com.plus1250.jobaTrend.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plus1250.jobaTrend.model.dto.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        final UsernamePasswordAuthenticationToken authRequest;

        final LoginDTO loginDTO;
        try {
            loginDTO = new ObjectMapper().readValue(request.getInputStream(), LoginDTO.class);
            System.out.println("loginDTO : " + loginDTO);
            authRequest = new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Token 발급 실패");
        }
        setDetails(request, authRequest);

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}