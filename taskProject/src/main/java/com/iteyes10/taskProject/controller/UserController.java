package com.iteyes10.taskProject.controller;

import com.iteyes10.taskProject.service.UserService;
import com.iteyes10.taskProject.vo.LoginRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest, HttpSession session){
        String id = userService.login(loginRequest);

        if(id != null){
            session.setAttribute("userId", id);

            return "success";
        }
        else
            return "failure";
    }

    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
