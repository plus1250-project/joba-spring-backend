package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.service.MailService;
import com.plus1250.jobaTrend.service.RefreshTokenService;
import com.plus1250.jobaTrend.service.UserService;
import com.plus1250.jobaTrend.service.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    private final JwtTokenProvider jwtTokenProvider;

    @Autowired
    private final RefreshTokenService refreshTokenService;

    // 회원가입
    @PostMapping(value = "/signup")
    public String insertUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO);
        return "signup";
    }

    // 회원 정보 조회
    @GetMapping(value = "/userinfo")
    public UserDTO info(@PathVariable String email) {
        UserDTO userDTO = userService.getInfo(email);
        return userDTO;
    }

    // 로그인
//    @PostMapping(value = "/login")
//    public ResponseEntity<TokenDTO> loginUser(@RequestBody UserDTO userDTO) {
//
////        ResponseEntity<TokenDTO> responseEntity = ResponseEntity.ok(userService.loginUser(userDTO));
//        return ResponseEntity.ok(userService.loginUser(userDTO));
////        return responseEntity.getBody().getAccessToken();
////        return null;
//    }

//    public String loginUser(@RequestBody String UserDTO) {
//        Map<String, String> result = new HashMap<>();
//        userServiceImpl.loginUser(result);
//        return "login";
//    }

    // 재발급
    @PostMapping("/reissue")
    public ResponseEntity<TokenDTO> reissue(@RequestBody RefreshRequest refreshRequest) {
        return ResponseEntity.ok(userService.reissue(refreshRequest));
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
        boolean pwFindCheck = userService.emailCheckUser(email, nickName);

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
        userService.updateUser(user);
    }

//    // 닉네임 수정
//    @PostMapping("/update/resetnickname")
//    public void updateUserNickname(@RequestBody User user) throws Exception {
//        userService.updateUserNickname(user);
//    }

    // 회원탈퇴
    @PostMapping("/delete")
    public void deleteUser(UserDTO userDTO) throws Exception {
        System.out.println("delete controller");
        System.out.println(userDTO.getEmail() + " | " + userDTO.getPassword());
        userService.deleteUser(userDTO.getPassword(), userDTO.getEmail());
    }

}