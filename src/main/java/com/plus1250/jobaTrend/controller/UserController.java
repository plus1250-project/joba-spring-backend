package com.plus1250.jobaTrend.controller;


import com.plus1250.jobaTrend.model.dto.UserDTO;
import com.plus1250.jobaTrend.model.entity.User;
import com.plus1250.jobaTrend.service.UserService;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
//    @PostMapping("/signup")
//    public void insertUser(@RequestBody UserDTO userDTO) {
//        System.out.println(userDTO);
//        return userService.insertUser(userDTO);
//    }

    @GetMapping(value = "/new")
    public String uer(Model model){
        model.addAttribute("UserDto", new UserDto());
        return "user";
    }

    @PostMapping(value = "/new")
    public String user(@Valid UserDTO userDTO, BindingResult bindingResult, Model model ) {
        if(bindingResult.hasErrors()){
            return "user";
        }

        try (
                User user = User.createUser(UserDTO userDTO);
                userService.insertUser(user);
                ) catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "user";
        }
    }   return "";


    // 로그인
    @PostMapping("/login")
    public Boolean loginUser(@RequestBody UserDTO userDTO) {
        System.out.println(userDTO);
        return userService.loginUser(userDTO);
    }

}
