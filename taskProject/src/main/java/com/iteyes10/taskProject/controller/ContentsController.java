package com.iteyes10.taskProject.controller;

import com.iteyes10.taskProject.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ContentsController {
    private final ContentsService contentsService;

    @Autowired
    public ContentsController(ContentsService contentsService){
        this.contentsService = contentsService;
    }
}