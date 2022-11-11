package com.plus1250.jobaTrend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationEntryPoint implements org.springframework.security.web.AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // user 정보 없이 접근 할 때 401
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}