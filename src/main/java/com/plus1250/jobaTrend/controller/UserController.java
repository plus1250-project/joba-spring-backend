package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.common.Data;
import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.model.entity.RefreshToken;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.service.MailService;
import com.plus1250.jobaTrend.service.RefreshTokenService;
import com.plus1250.jobaTrend.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class UserContoller {

    private final UserServiceImpl userServiceImpl;

    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenService refreshTokenService;

    // 회원가입
    @PostMapping(value = "/signup")
    public String insertUser(@RequestBody UserDTO userDTO) {
        userServiceImpl.insertUser(userDTO);
        return "signup";
    }

    // 회원 정보 조회
    @GetMapping(value = "/userinfo")
    public UserDTO info(@PathVariable String email) {
        UserDTO userDTO = userServiceImpl.getInfo(email);
        return userDTO;
    }

    // 로그인
    @PostMapping(value = "/login")
    public ResponseEntity<TokenDTO> loginUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userServiceImpl.loginUser(userDTO));
    }

//    public String loginUser(@RequestBody String UserDTO) {
//        Map<String, String> result = new HashMap<>();
//        userServiceImpl.loginUser(result);
//        return "login";
//    }

    // 재발급
    @PostMapping("/reissue")
    public ResponseEntity<TokenDTO> reissue(@RequestBody RefreshRequest refreshRequest) {
        return ResponseEntity.ok(userServiceImpl.reissue(refreshRequest));
    }

    // 로그아웃
    @PostMapping(value = "logout")
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }

    // 비밀 번호 찾기
    @GetMapping("/check/finpw")
    public @ResponseBody Map<String, Boolean> findpw(String email, String nickName) {

        Map<String,Boolean> json = new HashMap<>();
        boolean pwFindCheck = userServiceImpl.emailCheckUser(email, nickName);

        System.out.println(pwFindCheck);
        json.put("check", pwFindCheck);
        return json;
    }

    // 등록된 이메일로 임시비밀번호를 발송하고 발송된 임시비밀번호로 pw 변경
    @PostMapping("/check/findpw/sendemail")
    public @ResponseBody void sendEmail(String email) {
        MailDTO mailDTO = MailService.createMailChagePw(email);
        MailService.mailSend(mailDTO);

    }

    // 회원 정보 수정
    @PostMapping("/update")
    public void updateUser(@RequestBody User user) throws Exception {
        userServiceImpl.updateUser(user);
    }

    // 회원탈퇴
    @PostMapping("/delete")
    public void deleteUser(@RequestBody String password, String email) throws Exception {
        userServiceImpl.deleteUser(password, email);
    }

}