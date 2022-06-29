package com.plus1250.jobaTrend.controller;


import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.service.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 회원가입
    @PostMapping("/user")
    public void insertUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        userService.save(userDTO);
        return "redirect:/login";
    }



    // 회원 정보 수정
    @PostMapping("/update")
    public void updateUser(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    // 회원탈퇴
    @PostMapping("/delete")
    public void deleteUser(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO);
    }

    // 로그인
//   @PostMapping("/login")
//   public Boolean loginUser(@RequestBody UserDTO userDTO) {
//       System.out.println(userDTO);
//       return userService.loginUser(userDTO);
//   }

}
