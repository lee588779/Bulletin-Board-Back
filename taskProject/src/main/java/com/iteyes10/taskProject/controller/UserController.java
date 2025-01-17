package com.iteyes10.taskProject.controller;

import com.iteyes10.taskProject.service.UserService;
import com.iteyes10.taskProject.vo.LoginRequest;
import com.iteyes10.taskProject.vo.LoginResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session){
        LoginResponse response = userService.login(loginRequest);

        if(response != null){
            session.setAttribute("userId", response.getUid());
            session.setAttribute("level", response.getLevel());

            return ResponseEntity.ok(response);
        }
        else
            return ResponseEntity.status(401).body("User not found");
    }

    @PostMapping("/logout")
    public void logout(HttpSession session){
        session.invalidate();
    }
}
