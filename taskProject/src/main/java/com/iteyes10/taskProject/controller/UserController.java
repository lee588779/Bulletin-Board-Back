package com.iteyes10.taskProject.controller;

import com.iteyes10.taskProject.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
}
