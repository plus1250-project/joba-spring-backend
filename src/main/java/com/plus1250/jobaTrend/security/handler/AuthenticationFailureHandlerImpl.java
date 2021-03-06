package com.plus1250.jobaTrend.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        exception.printStackTrace();
        writePrintErrorResponse(response, exception);

    }
    private void writePrintErrorResponse(HttpServletResponse response, AuthenticationException exception) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> responseMap = new HashMap<>();
            String message = getExceptionMessage(exception);

            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.setCharacterEncoding(StandardCharsets.UTF_8.toString());

            PrintWriter writer = response.getWriter();

            responseMap.put("status", 401);
            responseMap.put("message", message);

            writer.write(objectMapper.writeValueAsString(responseMap));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getExceptionMessage(AuthenticationException exception) {

        if(exception instanceof AuthenticationServiceException) {
//            request.setAttribute("LoginFailMessage", "???????????????. ???????????? ????????? ??????????????????.");
            return "???????????????. ???????????? ????????? ??????????????????.";
        }

        else if(exception instanceof BadCredentialsException) {
            return "????????? ?????? ??????????????? ???????????? ????????????.";
        }
        else if(exception instanceof DisabledException) {
            return "?????? ????????? ??? ?????? ???????????????.";
        }
        else if(exception instanceof LockedException) {
            return "?????? ?????? ???????????????.";
        }
        else if(exception instanceof AccountExpiredException) {
            return "?????? ????????? ???????????????.";
        }
        else if(exception instanceof CredentialsExpiredException) {
            return "??????????????? ????????? ???????????????.";
        }
        else {
            return "????????? ?????? ??? ????????????.";
        }
    }
}