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
import com.iteyes10.taskProject.dto.update_data;
import com.iteyes10.taskProject.dto.write_data;
import com.iteyes10.taskProject.service.ContentsService;

import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/board")
public class ContentsController {
    
    private final ContentsService contentsService;

    public ContentsController(@Autowired ContentsService contentsService){
        this.contentsService = contentsService;
    }

    @PostMapping("/detail")
    public Contents contents_detail(@RequestBody intValue id, HttpSession session) {
        String uid = (String)session.getAttribute("userId");
        if(uid != null)
            return contentsService.get_detail(id.getValue());
        else
            return null;
    }
    
    @PostMapping("/{type}")
    public board_list contents_list(@PathVariable String type, @RequestBody intValue page, HttpSession session) {
        String uid = (String)session.getAttribute("userId");
        if(uid != null)
            return contentsService.get_contents_list(type, page.getValue());
        return null;
    }

    @PostMapping("/delete")
    public boolean contents_delete(@RequestBody intValue id, HttpSession session) {
        String uid = (String)session.getAttribute("userId");
        if(uid != null)
            return contentsService.contents_delete(id.getValue(), uid);
        return false;
    }
    
    @PostMapping("/update")
    public Contents contents_update(@RequestBody update_data data, HttpSession session) {
        String uid = (String)session.getAttribute("userId");
        if(uid != null)
            return contentsService.contents_update(data, uid);
        return null;
    }
    
    @PostMapping("/write")
    public Contents contents_write(@RequestBody write_data data, HttpSession session) {
        String uid = (String)session.getAttribute("userId");
        String level = (String)session.getAttribute("level");
        if(uid == null)   
            return null;
        if(!(data.getType().equals("0") && level.equals("admin")))
            return null;
        return contentsService.contents_write(data, uid);
    }


}