package com.plus1250.jobaTrend.controller;

import com.plus1250.jobaTrend.model.dto.*;
import com.plus1250.jobaTrend.service.MailService;
import com.plus1250.jobaTrend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/member")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final MailService mailService;

    // 회원가입
    @PostMapping(value = "/signup")
    public String insertUser(@RequestBody UserDTO userDTO) {
        userService.insertUser(userDTO);
        return "success";
    }

    // 회원 정보 조회
    @GetMapping
    public UserDTO info(@RequestParam String email) {
        UserDTO userDTO = userService.getInfo(email);
        return userDTO;
    }

    // 로그인 전 비밀번호 찾기 - 메일 전송
    @PostMapping("/find-password")
    public @ResponseBody void sendEmail(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO.getEmail());
        MailDTO mailDTO = mailService.createChangePassword(userDTO);
        mailService.mailSend(mailDTO);
    }

    // 닉네임 변경
    @PatchMapping("/nickname")
    public void updateUserNickname(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println(userDTO.getEmail() + " | " + userDTO.getNickName());
        userService.updateUserNickname(userDTO);
    }

    // 비밀번호 변경
    @PatchMapping("/password")
    public void updateUserPassword(@RequestBody UserDTO userDTO) throws Exception {
        userService.updateUserPassword(userDTO);
    }

    // 회원탈퇴
    @DeleteMapping
    public void deleteUser(@RequestBody UserDTO userDTO) throws Exception {
        System.out.println("delete controller");
        System.out.println(userDTO.getEmail() + " | " + userDTO.getPassword());
        userService.deleteUser(userDTO.getPassword(), userDTO.getEmail());
    }
}