package com.plus1250.jobaTrend.security.handler;

import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.dto.RefreshResponse;
import com.plus1250.jobaTrend.model.dto.TokenDTO;
import io.jsonwebtoken.Jwt;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

//        response.setStatus(HttpStatus.OK.value());



        try( PrintWriter writer = response.getWriter()) {

            TokenDTO jwt = jwtTokenProvider.createToken(authentication);
            JSONObject json = new JSONObject();

            json.put("accessToken",jwt.getAccessToken());

            response.setStatus(HttpStatus.ACCEPTED.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

            writer.write(json.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

