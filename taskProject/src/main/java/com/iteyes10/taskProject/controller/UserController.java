package com.iteyes10.taskProject.controller;

import com.iteyes10.taskProject.service.UserService;
import com.iteyes10.taskProject.vo.LoginRequest;
import com.iteyes10.taskProject.vo.LoginResponse;
import jakarta.servlet.http.HttpSession;
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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session){
        LoginResponse response = userService.login(loginRequest);
        //String id = userService.login(loginRequest);

        if(response != null){
            session.setAttribute("userId", response.getUid());

            return ResponseEntity.ok(response); //return "success";
        }
        else
            return ResponseEntity.status(401).body("User not found"); //return "failure";
    }

    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
