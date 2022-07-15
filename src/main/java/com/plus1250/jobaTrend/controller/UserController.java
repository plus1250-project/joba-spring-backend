package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.jwt.JwtTokenProvider;
import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.service.MailService;
import com.plus1250.jobaTrend.service.RefreshTokenService;
import com.plus1250.jobaTrend.service.UserService;
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
    private final MailService mailService;

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

    // 이메일과 닉네임 일치 여부 확인
    @GetMapping("/finpw")
    public @ResponseBody Map<String, Boolean> findPassword(String email, String nickName) {

        Map<String,Boolean> json = new HashMap<>();
        boolean findCheck = userService.emailCheckNickname(email, nickName);

        System.out.println(findCheck);
        json.put("check", findCheck);
        return json;
    }

    // 비밀번호 찾기
    @PostMapping("sendemail")
    public @ResponseBody void sendEmail(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getEmail() + " | " + userDTO.getNickName());

        MailDTO mailDTO = mailService.createChangePassword(userDTO);
        mailService.mailSend(mailDTO);
    }


    // 닉네임 변경
    @PostMapping("/updatenickname")
    public void updateUserNickname(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getEmail() + " | " + userDTO.getNickName());
        userService.updateUserNickname(userDTO);
    }

    // 비밀번호 변경
    @PostMapping("/updatepassword")
    public void updateUserPassword(@RequestBody UserDTO userDTO) throws Exception {
        userService.updateUserPassword(userDTO);
    }

    // 회원탈퇴
    @PostMapping("/delete")
    public void deleteUser(UserDTO userDTO) throws Exception {
        System.out.println("delete controller");
        System.out.println(userDTO.getEmail() + " | " + userDTO.getPassword());
        userService.deleteUser(userDTO.getPassword(), userDTO.getEmail());
    }

}