package com.iteyes10.taskProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iteyes10.taskProject.domain.Contents;
import com.iteyes10.taskProject.dto.board_list;
import com.iteyes10.taskProject.dto.intValue;
import com.iteyes10.taskProject.service.ContentsService;



@RestController
@RequestMapping("/board")
public class ContentsController {
    @Autowired
    private final ContentsService contentsService;

    public ContentsController(ContentsService contentsService){
        this.contentsService = contentsService;
    }

    @PostMapping("/detail")
    public Contents contents_detail(@PathVariable String type, @RequestBody intValue id) {
        return contentsService.get_detail(id.getValue());
    }
    
    @PostMapping("/{type}")
    public board_list contents_list(@PathVariable String type, @RequestBody intValue page) {
        return new board_list(contentsService.get_contents_list(type, page.getValue()));
    }



    
}